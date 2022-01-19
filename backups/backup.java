base 97 line.

//1.获取当前用户在此小区下的角色。  findRoleListVOByTempateId
roleId;


//2.设置一个Map，存储社区roleId到财管roleId的映射（固定值）
//！注意，该接口不支持新增角色功能。
Map<String,String> map = new HashMap<String,String>();
map.put("6185663684036414631","55");
......

//3.设置roleId为合式值
jsonObject.put("roleId",map.get(roleId));


public String getRoleId(人){
	//1.获取当前用户在此小区下的角色。  findRoleListVOByTempateId
	得到roleId_shequ;
	//2. 设置一个Map，存储社区roleId到财管roleId的映射（固定值）
	Map<String,String> map = new HashMap<String,String>();
	map.put("6185663684036414631","55");
	......;
	
	//3.返回财管对应roleId
	return map.get(roleId_shequ));
}


测试环境阿里云资源登录方式：
RAM用户登录地址
https://signin.aliyun.com/1086332967693011.onaliyun.com/login.htm
账号：guohantao@1086332967693011.onaliyun.com
密码：guohantao123
rancher测试环境：日志管理平台
https://gxsxfltest-rancher.zjfsjk.com/（需要设置hosts文件 47.103.159.150 gxsxfltest-rancher.zjfsjk.com）
admin / aodHLk+VZyh0l7LO

管理端测试环境地址:https://gxsxfltest.zjfsjk.com/login/toCompanyLogin.action?d=gxsxfltest
用户名11个1密码mima123