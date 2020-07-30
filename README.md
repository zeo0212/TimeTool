# TimeTool
时间工具类，毫秒转你想要的时间格式。各种格式转毫秒等
当前版本1.0


        //毫秒转换  默认  "yyyy-MM-dd HH:mm:ss"
        TimeChange.getInstanceSafe().getTimeStr(System.currentTimeMillis());
        //毫秒转换  你需要的  比如 ："MM-dd"
        TimeChange.getInstanceSafe().getTimeStr(System.currentTimeMillis(), "MM-dd");
        //字符串转换   你需要的  比如 ："MM-dd"
        TimeChange.getInstanceSafe().getTimeStr("2020-12-12 00:00:00", "MM-dd");
        //字符串转换   后台给的格式 如2020/12/12 00:00:00   、 2020年12月12日 00时00分00秒
        TimeChange.getInstanceSafe().getTimeStr("2020/12/12 00:00:00", "yyyy/MM/dd HH:mm:ss", "MM-dd");
        TimeChange.getInstanceSafe().getTimeStr("2020-12-12 00:00:00", "yyyy年MM月dd日 HH时mm分ss秒", "MM-dd");
        //刚刚   10秒前   1小时    等等
        TimeChange.getInstanceSafe().getTimeLossStr(TimeChange.getInstanceSafe().getTimeStr(System.currentTimeMillis() - 10), null);
        //转毫秒
        TimeChange.getInstanceSafe().getTimemIllisecond("2020/12/12 00:00:00");


dependencies {


	        implementation 'com.github.zeo0212:TimeTool:1.0'
	
	
	}
