public String getRoleId(String personId,String orgId) throws BaseException{//by LiangHan
	//1. 设置一个Map，存储社区roleId到财管roleId的映射（固定值）,应急之策，需要想出一个合理的解决方案
	Map<String,String> map = new HashMap<String,String>();
	map.put("6185663684036414631","55");//业委会主任
	map.put("3999073721926239011","56");//业委会副主任
	map.put("2061686267253572451","57");//业委会出纳
	map.put("8438588791977365490","58");//业委会财务
	map.put("7988451172166420745","60");//业委会党员代表
	map.put("4274171722052028574","61");//监督组长
	map.put("2888469845658911730","62");//监督副组长
	map.put("4238506775948118790","63");//监督组员
	map.put("3653890400458197576","76");//党组织书记
	map.put("2972730667697259530","77");//党组织副书记
	map.put("1802548995143255316","78");//党组织委员
	map.put("5831419701278752898","64");//物业经理
	map.put("3501649455641216951","71");//楼栋长
	map.put("2985178036636370769","59");//业主代表
	map.put("2731639127037724830","65");//社区管理员
	map.put("6767042438277382203","66");//社区监督员
	map.put("5706500732779053922","67");//街道管理员
	map.put("5250664360776781127","68");//街道监督员
	map.put("4085778004663094919","69");//区县管理员
	map.put("474855901102426943","70");//市级管理员
	map.put("6872939582239752801","1");//系统管理员
	map.put("4403229056248333767","72");//业主
	map.put("287033361819388579","73");//家属
	map.put("3532746066895520154","74");//租户

	//2.获取当前用户在此小区下的角色。
	List<Long> roleIdList = personOrgService.findRoleIdListByPersonIdAndOrgId(personId,orgId);

	String roleId_shequ=String.valueOf(roleIdList.get(1));//固定取得角色列表第一个角色，需要及时修改,LiangHan。
	if(map.containsKey(roleId_shequ)==false){
		LOGGER.error("IO异常："+"财管系统无此角色！");
		throw new BaseException("IO异常："+"财管系统无此角色！");
	}
	else{
		//3.返回财管对应roleId
		return map.get(roleId_shequ);
	}
}