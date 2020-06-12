package cj.netos.uc.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class NumberGen {

	public static String gen() {// 00190506155043,00为固定，19是年，0506是月日，61550时分秒，43是随机两位
		String no = "";
		no = String.format("00%s", no);
		SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmss");
		no = String.format("%s%s", no, format.format(new Date(System.currentTimeMillis())));
		int v = new Random().nextInt(10);
		no = String.format("%s%s", no, Math.abs(v));
		v = new Random().nextInt(10);
		no = String.format("%s%s", no, Math.abs(v));
		return no;
	}
	public static void main(String...strings) {
		System.out.println(genVerifyCode());
	}

	public  static String genVerifyCode(){
		int a= Math.abs((UUID.randomUUID()+""+System.nanoTime()).hashCode()) %10;
		int b=Math.abs((UUID.randomUUID()+""+System.nanoTime()).hashCode())%10;
		int c=Math.abs((UUID.randomUUID()+""+System.nanoTime()).hashCode())%10;
		int d=Math.abs((UUID.randomUUID()+""+System.nanoTime()).hashCode())%10;
		int e=Math.abs((UUID.randomUUID()+""+System.nanoTime()).hashCode())%10;
		int f=Math.abs((UUID.randomUUID()+""+System.nanoTime()).hashCode())%10;
		return String.format("%d%d%d%d%d%d",a,b,c,d,e,f);
	}
}
