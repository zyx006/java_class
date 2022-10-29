package work3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateCode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入类名：");
        String className = scanner.nextLine();
        System.out.println("请输入成员变量的名称和类型(如studentId,String)，以'end'结束输入：");

        List<Field> fields = new ArrayList<>();
        while (true){
            String fieldStr = scanner.nextLine();
            if ("end".equals(fieldStr)){
                break;
            }
            String[] nameAndType = fieldStr.split("[,，]");
            fields.add(new Field(nameAndType[0], nameAndType[1]));
        }
        writeCode(className, fields);
    }

    public static void writeCode(String className, List<Field> fields){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter( className + ".java"))) {
            //类开始
            bw.write("public class " + className + " {\n");

            int size = fields.size();
            //成员变量
            for (Field field : fields) {
                bw.write("\tprivate " + field.getAttributeType() + " " + field.getAttributeName() + ";\n");
            }
            bw.write("\n");

            //无参构造
            bw.write("\tpublic " + className + "() {\n\n\t}\n\n");

            //全参构造参数列表
            bw.write("\tpublic " + className + "(");
            for (int i = 0; i < size; i++) {
                Field field = fields.get(i);
                bw.write(field.getAttributeType() + " " + field.getAttributeName());
                if(i != size-1){
                    bw.write(", ");
                }
            }
            bw.write(") {\n");
            //全参构造函数体
            for (Field field : fields) {
                bw.write("\t\tthis." + field.getAttributeName() + " = " + field.getAttributeName() + ";\n");
            }
            bw.write("\t}\n\n");

            //各成员变量的get/set方法
            for (Field field : fields) {
                //用于get/set方法的属性名
                String attributeName = field.getAttributeName();
                attributeName = attributeName.substring(0, 1).toUpperCase() + attributeName.substring(1);
                //get方法
                bw.write("\tpublic " + field.getAttributeType() + " get" + attributeName + "() {\n");
                bw.write("\t\treturn " + field.getAttributeName() + ";\n\t}\n\n");
                //set方法
                bw.write("\tpublic void" + " set" + attributeName + "(" +
                        field.getAttributeType() + " " + field.getAttributeName() + ") {\n");
                bw.write("\t\tthis." + field.getAttributeName() + " = " + field.getAttributeName() + ";\n\t}\n\n");
            }

            //toString方法
            bw.write("\t@Override\n\tpublic String toString() {\n");
            bw.write("\t\treturn \"" + className + "{\" +\n");
            for (int i = 0; i < size; i++) {
                Field field = fields.get(i);
                bw.write("\t\t\t\t\"");
                if(i != 0){
                    bw.write(", ");
                }
                if ("String".equals(field.getAttributeType())) {
                    bw.write(field.getAttributeName() + "='\" + " + field.getAttributeName() + " + '\\'' +\n");
                } else {
                    bw.write(field.getAttributeName() + "=\" + " + field.getAttributeName() + " + \n");
                }
            }
            bw.write("\t\t\t\t'}';\n\t}\n");

            //类结束
            bw.write("}");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
