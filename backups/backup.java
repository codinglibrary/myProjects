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