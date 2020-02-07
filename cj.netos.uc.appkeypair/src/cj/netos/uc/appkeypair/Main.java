package cj.netos.uc.appkeypair;

import cj.ultimate.util.StringUtil;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String... args) throws IOException {
        String home = System.getProperty("user.home");
        String fileName = String.format("%s/appkeypair.tmp", home);
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }

        Properties properties = new Properties();
        FileReader reader = new FileReader(file);
        properties.load(reader);

        System.out.print("**************缓存的上次生成的appkeypari*****************************************************\r\n");
        System.out.println(String.format("\tappid    : %s", properties.getProperty("appid")));
        System.out.println(String.format("\tappKey   : %s", properties.getProperty("appKey")));
        System.out.println(String.format("\tappNonce : %s", properties.getProperty("appNonce")));
        System.out.println(String.format("\tappSign  : %s", properties.getProperty("appSign")));
        System.out.println(String.format("\tappSecret  : %s", properties.getProperty("appSecret")));

        Scanner scanner = new Scanner(System.in);

        System.out.print("*************以下生成新的appkeypair，只需输入appKey和appSecret。不想生成新的输入!q **************\r\n");
        System.out.print("输入appid    > ");
        String appid = scan(scanner);
        System.out.print("输入appKey    > ");
        String appKey = scan(scanner);
        System.out.print("输入appSecret > ");
        String appSecret = scan(scanner);
        String nonce = Encript.md5(UUID.randomUUID().toString());
        String sign = Encript.md5(String.format("%s%s%s", appKey, nonce, appSecret));
        System.out.println("结果：");
        System.out.println(String.format("\tappid    : %s", appid));
        System.out.println(String.format("\tappKey   : %s", appKey));
        System.out.println(String.format("\tappNonce : %s", nonce));
        System.out.println(String.format("\tappSign  : %s", sign));
        System.out.println();
        System.out.println();
        System.out.println("使用的appSecret是：");
        System.out.println(String.format("\t> %s", appSecret));

        properties.put("appid", appid);
        properties.put("appKey", appKey);
        properties.put("appNonce", nonce);
        properties.put("appSign", sign);
        properties.put("appSecret", appSecret);

        FileWriter writer
                = new FileWriter(file);
        properties.store(writer, "appkeypair");
        System.out.println("已保存到网关下");
    }

    private static String scan(Scanner scanner) {
        String text = "";
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (StringUtil.isEmpty(line)) {
                System.out.print("      >");
                continue;
            }
            if ("bye".equals(line) || "exit".equals(line)) {
                break;
            }
            if ("!q".equals(line)) {
                System.exit(1);
            }
            text = line;
            break;
        }
        return text;
    }
}
