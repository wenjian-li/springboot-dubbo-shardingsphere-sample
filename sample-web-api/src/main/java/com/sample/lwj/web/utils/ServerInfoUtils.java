package com.sample.lwj.web.utils;

import com.sample.lwj.utils.ArithUtils;
import com.sample.lwj.utils.DateUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.FileSystem;
import oshi.software.os.OSFileStore;
import oshi.software.os.OperatingSystem;
import oshi.util.Util;

import java.lang.management.ManagementFactory;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

/**
 * @author vincent.li
 * @version 1.0.0
 * @Description: 服务器资源信息
 * @date 2021/11/8 17:07
 */
public class ServerInfoUtils {

    public static ServerDTO getServerInfo() {
        ServerDTO serverDTO = new ServerDTO();
        serverDTO.loading();
        return serverDTO;
    }


    /**
     * 加载系统信息
     */
    @ApiModel("服务器资源信息")
    public static class ServerDTO {
        /**
         * CPU相关信息
         */
        private Cpu cpu = new Cpu();

        /**
         * 內存相关信息
         */
        private Mem mem = new Mem();

        /**
         * JVM相关信息
         */
        private Jvm jvm = new Jvm();

        /**
         * 服务器相关信息
         */
        private Sys sys = new Sys();

        /**
         * 磁盘相关信息
         */
        private List<SysFile> sysFiles = new LinkedList<SysFile>();

        public Cpu getCpu() {
            return cpu;
        }

        public void setCpu(Cpu cpu) {
            this.cpu = cpu;
        }

        public Mem getMem() {
            return mem;
        }

        public void setMem(Mem mem) {
            this.mem = mem;
        }

        public Jvm getJvm() {
            return jvm;
        }

        public void setJvm(Jvm jvm) {
            this.jvm = jvm;
        }

        public Sys getSys() {
            return sys;
        }

        public void setSys(Sys sys) {
            this.sys = sys;
        }

        public List<SysFile> getSysFiles() {
            return sysFiles;
        }

        public void loadingSysFiles(List<SysFile> sysFiles) {
            this.sysFiles = sysFiles;
        }

        /**
         * 加载资源信息
         */
        public void loading() {
            SystemInfo systemInfo = new SystemInfo();

            HardwareAbstractionLayer hal = systemInfo.getHardware();
            //加载CPU信息
            loadingCpuInfo(hal.getProcessor());
            //加载内存信息
            loadingMemInfo(hal.getMemory());
            //加载磁盘信息
            loadingSysFiles(systemInfo.getOperatingSystem());
            //加载系统信息
            loadingSysInfo();
            //加载JVM信息
            loadingJvmInfo();

        }

        /**
         * 加载CPU信息
         */
        private void loadingCpuInfo(CentralProcessor processor) {
            // CPU信息
            long[] prevTicks = processor.getSystemCpuLoadTicks();
            Util.sleep(500);
            long[] ticks = processor.getSystemCpuLoadTicks();
            long nice = ticks[CentralProcessor.TickType.NICE.getIndex()] - prevTicks[CentralProcessor.TickType.NICE.getIndex()];
            long irq = ticks[CentralProcessor.TickType.IRQ.getIndex()] - prevTicks[CentralProcessor.TickType.IRQ.getIndex()];
            long softirq = ticks[CentralProcessor.TickType.SOFTIRQ.getIndex()] - prevTicks[CentralProcessor.TickType.SOFTIRQ.getIndex()];
            long steal = ticks[CentralProcessor.TickType.STEAL.getIndex()] - prevTicks[CentralProcessor.TickType.STEAL.getIndex()];
            long cSys = ticks[CentralProcessor.TickType.SYSTEM.getIndex()] - prevTicks[CentralProcessor.TickType.SYSTEM.getIndex()];
            long user = ticks[CentralProcessor.TickType.USER.getIndex()] - prevTicks[CentralProcessor.TickType.USER.getIndex()];
            long iowait = ticks[CentralProcessor.TickType.IOWAIT.getIndex()] - prevTicks[CentralProcessor.TickType.IOWAIT.getIndex()];
            long idle = ticks[CentralProcessor.TickType.IDLE.getIndex()] - prevTicks[CentralProcessor.TickType.IDLE.getIndex()];
            long totalCpu = user + nice + cSys + idle + iowait + irq + softirq + steal;
            cpu.setCpuNum(processor.getLogicalProcessorCount());
            cpu.setTotal(totalCpu);
            cpu.setSys(cSys);
            cpu.setUsed(user);
            cpu.setWait(iowait);
            cpu.setFree(idle);
        }

        /**
         * 加载内存信息
         */
        private void loadingMemInfo(GlobalMemory memory) {
            mem.setTotal(memory.getTotal());
            mem.setUsed(memory.getTotal() - memory.getAvailable());
            mem.setFree(memory.getAvailable());
        }

        /**
         * 加载服务器信息
         */
        private void loadingSysInfo() {
            Properties props = System.getProperties();
            sys.setComputerName(IpUtils.getHostName());
            sys.setComputerIp(IpUtils.getHostIp());
            sys.setOsName(props.getProperty("os.name"));
            sys.setOsArch(props.getProperty("os.arch"));
            sys.setUserDir(props.getProperty("user.dir"));
        }

        /**
         * 加载Java虚拟机
         */
        private void loadingJvmInfo() {
            Properties props = System.getProperties();
            jvm.setTotal(Runtime.getRuntime().totalMemory());
            jvm.setMax(Runtime.getRuntime().maxMemory());
            jvm.setFree(Runtime.getRuntime().freeMemory());
            jvm.setVersion(props.getProperty("java.version"));
            jvm.setHome(props.getProperty("java.home"));
        }

        /**
         * 加载磁盘信息
         */
        private void loadingSysFiles(OperatingSystem os) {
            FileSystem fileSystem = os.getFileSystem();
            List<OSFileStore> fsArray = fileSystem.getFileStores();
            for (OSFileStore fs : fsArray) {
                long free = fs.getUsableSpace();
                long total = fs.getTotalSpace();
                long used = total - free;
                SysFile sysFile = new SysFile();
                sysFile.setDirName(fs.getMount());
                sysFile.setSysTypeName(fs.getType());
                sysFile.setTypeName(fs.getName());
                sysFile.setTotal(convertFileSize(total));
                sysFile.setFree(convertFileSize(free));
                sysFile.setUsed(convertFileSize(used));
                sysFile.setUsage(ArithUtils.mul(ArithUtils.div(used, total, 4), 100));
                sysFiles.add(sysFile);
            }
        }

        /**
         * 字节转换
         *
         * @param size 字节大小
         * @return 转换后值
         */
        public String convertFileSize(long size) {
            long kb = 1024;
            long mb = kb * 1024;
            long gb = mb * 1024;
            if (size >= gb) {
                return String.format("%.1f GB", (float) size / gb);
            } else if (size >= mb) {
                float f = (float) size / mb;
                return String.format(f > 100 ? "%.0f MB" : "%.1f MB", f);
            } else if (size >= kb) {
                float f = (float) size / kb;
                return String.format(f > 100 ? "%.0f KB" : "%.1f KB", f);
            } else {
                return String.format("%d B", size);
            }
        }
    }


    //扩展类

    /**
     * CPU信息
     */
    @ApiModel("CPU信息")
    public static class Cpu {
        /**
         * 核心数
         */
        @ApiModelProperty("核心数")
        private int cpuNum;

        /**
         * CPU总的使用率
         */
        @ApiModelProperty("CPU总的使用率")
        private double total;

        /**
         * CPU系统使用率
         */
        @ApiModelProperty("CPU系统使用率")
        private double sys;

        /**
         * CPU用户使用率
         */
        @ApiModelProperty("CPU用户使用率")
        private double used;

        /**
         * CPU当前等待率
         */
        @ApiModelProperty("CPU当前等待率")
        private double wait;

        /**
         * CPU当前空闲率
         */
        @ApiModelProperty("CPU当前空闲率")
        private double free;

        public int getCpuNum() {
            return cpuNum;
        }

        public void setCpuNum(int cpuNum) {
            this.cpuNum = cpuNum;
        }

        public double getTotal() {
            return ArithUtils.round(ArithUtils.mul(total, 100), 2);
        }

        public void setTotal(double total) {
            this.total = total;
        }

        public double getSys() {
            return ArithUtils.round(ArithUtils.mul(sys / total, 100), 2);
        }

        public void setSys(double sys) {
            this.sys = sys;
        }

        public double getUsed() {
            return ArithUtils.round(ArithUtils.mul(used / total, 100), 2);
        }

        public void setUsed(double used) {
            this.used = used;
        }

        public double getWait() {
            return ArithUtils.round(ArithUtils.mul(wait / total, 100), 2);
        }

        public void setWait(double wait) {
            this.wait = wait;
        }

        public double getFree() {
            return ArithUtils.round(ArithUtils.mul(free / total, 100), 2);
        }

        public void setFree(double free) {
            this.free = free;
        }
    }

    /**
     * JVM信息
     */
    @ApiModel("JVM信息")
    public static class Jvm {
        /**
         * 当前JVM占用的内存总数(M)
         */
        @ApiModelProperty("当前JVM占用的内存总数(M)")
        private double total;

        /**
         * JVM最大可用内存总数(M)
         */
        @ApiModelProperty("JVM最大可用内存总数(M)")
        private double max;

        /**
         * JVM空闲内存(M)
         */
        @ApiModelProperty("JVM空闲内存(M)")
        private double free;

        /**
         * JDK版本
         */
        @ApiModelProperty("JDK版本")
        private String version;

        /**
         * JDK路径
         */
        @ApiModelProperty("JDK路径")
        private String home;

        /**
         * JDK名称
         */
        @ApiModelProperty("JDK名称")
        private String name;

        /**
         * JDK启动时间
         */
        @ApiModelProperty("JDK启动时间")
        private String startTime;

        /**
         * JDK运行时间
         */
        @ApiModelProperty("JDK运行时间")
        private String runTime;

        /**
         * 已经使用量
         */
        @ApiModelProperty("已经使用量(M)")
        private String used;

        /**
         * 资源的使用率
         */
        @ApiModelProperty("资源的使用率")
        private double usage;

        public double getTotal() {
            return ArithUtils.div(total, (1024 * 1024), 2);
        }

        public void setTotal(double total) {
            this.total = total;
        }

        public double getMax() {
            return ArithUtils.div(max, (1024 * 1024), 2);
        }

        public void setMax(double max) {
            this.max = max;
        }

        public double getFree() {
            return ArithUtils.div(free, (1024 * 1024), 2);
        }

        public void setFree(double free) {
            this.free = free;
        }

        public double getUsed() {
            return ArithUtils.div(total - free, (1024 * 1024), 2);
        }

        public double getUsage() {
            return ArithUtils.mul(ArithUtils.div(total - free, total, 4), 100);
        }

        /**
         * 获取JDK名称
         */
        public String getName() {
            return ManagementFactory.getRuntimeMXBean().getVmName();
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getHome() {
            return home;
        }

        public void setHome(String home) {
            this.home = home;
        }

        /**
         * JDK启动时间
         */
        public String getStartTime() {
            return DateUtils.format(DateUtils.getServerStartDate(), DateUtils.YYYY_MM_DD_HH_MM_SS);
        }

        /**
         * JDK运行时间
         */
        public String getRunTime() {
            return DateUtils.getDatePoor(DateUtils.getServerStartDate(), DateUtils.getNowDate());
        }
    }

    /**
     * 内存信息
     */
    @ApiModel("内存信息")
    public static class Mem {
        /**
         * 内存总量
         */
        @ApiModelProperty("内存总量")
        private double total;

        /**
         * 已用内存
         */
        @ApiModelProperty("已用内存")
        private double used;

        /**
         * 剩余内存
         */
        @ApiModelProperty("剩余内存")
        private double free;

        public double getTotal() {
            return ArithUtils.div(total, (1024 * 1024 * 1024), 2);
        }

        public void setTotal(long total) {
            this.total = total;
        }

        public double getUsed() {
            return ArithUtils.div(used, (1024 * 1024 * 1024), 2);
        }

        public void setUsed(long used) {
            this.used = used;
        }

        public double getFree() {
            return ArithUtils.div(free, (1024 * 1024 * 1024), 2);
        }

        public void setFree(long free) {
            this.free = free;
        }

        public double getUsage() {
            return ArithUtils.mul(ArithUtils.div(used, total, 4), 100);
        }
    }

    /**
     * 系统信息
     */
    @ApiModel("系统信息")
    public static class Sys {
        /**
         * 服务器名称
         */
        @ApiModelProperty("服务器名称")
        private String computerName;

        /**
         * 服务器Ip
         */
        @ApiModelProperty("服务器Ip")
        private String computerIp;

        /**
         * 项目路径
         */
        @ApiModelProperty("项目路径")
        private String userDir;

        /**
         * 操作系统
         */
        @ApiModelProperty("操作系统")
        private String osName;

        /**
         * 系统架构
         */
        @ApiModelProperty("系统架构")
        private String osArch;

        public String getComputerName() {
            return computerName;
        }

        public void setComputerName(String computerName) {
            this.computerName = computerName;
        }

        public String getComputerIp() {
            return computerIp;
        }

        public void setComputerIp(String computerIp) {
            this.computerIp = computerIp;
        }

        public String getUserDir() {
            return userDir;
        }

        public void setUserDir(String userDir) {
            this.userDir = userDir;
        }

        public String getOsName() {
            return osName;
        }

        public void setOsName(String osName) {
            this.osName = osName;
        }

        public String getOsArch() {
            return osArch;
        }

        public void setOsArch(String osArch) {
            this.osArch = osArch;
        }
    }

    /**
     * 系统磁盘信息
     */
    @ApiModel("系统磁盘信息")
    public static class SysFile {
        /**
         * 盘符路径
         */
        @ApiModelProperty("盘符路径")
        private String dirName;

        /**
         * 盘符类型
         */
        @ApiModelProperty("盘符类型")
        private String sysTypeName;

        /**
         * 文件类型
         */
        @ApiModelProperty("文件类型")
        private String typeName;

        /**
         * 总大小
         */
        @ApiModelProperty("银行机构ID")
        private String total;

        /**
         * 剩余大小
         */
        @ApiModelProperty("剩余大小")
        private String free;

        /**
         * 已经使用量
         */
        @ApiModelProperty("已经使用量")
        private String used;

        /**
         * 资源的使用率
         */
        @ApiModelProperty("资源的使用率")
        private double usage;

        public String getDirName() {
            return dirName;
        }

        public void setDirName(String dirName) {
            this.dirName = dirName;
        }

        public String getSysTypeName() {
            return sysTypeName;
        }

        public void setSysTypeName(String sysTypeName) {
            this.sysTypeName = sysTypeName;
        }

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getFree() {
            return free;
        }

        public void setFree(String free) {
            this.free = free;
        }

        public String getUsed() {
            return used;
        }

        public void setUsed(String used) {
            this.used = used;
        }

        public double getUsage() {
            return usage;
        }

        public void setUsage(double usage) {
            this.usage = usage;
        }
    }
}
