public static void main(String[] args) throws Exception{

    //加密并进行urlEncode
    String secretKey = "ZJRCU+XFL+SQGJ";
    Long timestamp = new Date().getTime();
    //组装加密串  personId userPhone areaId timestamp
    StringBuffer plainData = new StringBuffer().append("8586771430463459067").append("|").append("15805771796").append("|").append("12345").append("|").append(timestamp);
    //des加密
    String token = DesUtil.encryption(plainData.toString(),secretKey);
    //urlEncode
    String tokenUrlEncode = URLEncoder.encode(token,"UTF-8");
    System.out.println(tokenUrlEncode);

    //urlDecode并进行解密
    /*String tokenUrlDecode = URLDecoder.decode(tokenUrlEncode,"UTF-8");
    String tokenDecode = DesUtil.decryption(tokenUrlDecode,secretKey);
    System.out.println(tokenDecode);*/

}


https://xfl.zj96596.com.cn:9080/?param=
