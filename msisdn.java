import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class msisdn {

	public static void main(String[] args) throws Exception {

		String testMSISDN1 = "03051692278";
		String testMSISDN2 = "903051692278";
		String testMSISDN3 = "3051692278";
		String testMSISDN4 = "212121";
		String finalMSISDN = null;
		
		//test 1
		finalMSISDN = fixMSISDN(testMSISDN1);
		if(finalMSISDN != null){
			System.out.println("Initial MSISDN:" + testMSISDN1+ " -- finalMSISDN :" + finalMSISDN);
		}else{
			System.out.println("Initial MSISDN:" + testMSISDN1+ " -- INVALID");
		}
		
		//test 2
		finalMSISDN = fixMSISDN(testMSISDN2);
		if(finalMSISDN != null){
			System.out.println("Initial MSISDN:" + testMSISDN2+ " -- finalMSISDN :" + finalMSISDN);
		}else{
			System.out.println("Initial MSISDN:" + testMSISDN2+ " -- INVALID");
		}
		
		//test 3
		finalMSISDN = fixMSISDN(testMSISDN3);
		if(finalMSISDN != null){
			System.out.println("Initial MSISDN:" + testMSISDN3+ " -- finalMSISDN :" + finalMSISDN);
		}else{
			System.out.println("Initial MSISDN:" + testMSISDN3+ " -- INVALID");
		}
		
		//test 4
		finalMSISDN = fixMSISDN(testMSISDN4);
		if(finalMSISDN != null){
			System.out.println("Initial MSISDN:" + testMSISDN4+ " -- finalMSISDN :" + finalMSISDN);
		}else{
			System.out.println("Initial MSISDN:" + testMSISDN4+ " -- INVALID");
		}
		
		

	}
	
	public static String fixMSISDN(String testMSISDN){
		String CC = "90";
		String numberLength = "10";
		String finalMSISDN = null;
		
		Pattern msisdnWithCC= Pattern.compile("^("+CC+")([0-9]{"+numberLength+"})$");
		Pattern msisdnWithoutCC= Pattern.compile("^(0)([0-9]{"+numberLength+"})$");
		Pattern msisdnWithoutZero= Pattern.compile("^([0-9]{"+numberLength+"})$");
	
		 Matcher teststring= msisdnWithCC.matcher(testMSISDN);

		if(teststring.matches())
		{
			finalMSISDN = testMSISDN;
		}else{
			teststring = msisdnWithoutCC.matcher(testMSISDN);
			if(teststring.matches()){
				finalMSISDN = CC+teststring.group(2);
			}else{
				teststring = msisdnWithoutZero.matcher(testMSISDN);
				if(teststring.matches()){
					finalMSISDN = CC+teststring.group(1);
				}
			}
		}
		return finalMSISDN;
	}

}
