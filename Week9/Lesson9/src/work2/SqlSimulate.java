package work2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.*;

public class SqlSimulate {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("请输入命令(输入help显示帮助信息)：");
            String opt = scanner.nextLine();
            if ("exit".equalsIgnoreCase(opt)) {
                System.out.println("欢迎下次使用！");
                return;
            }

            String[] optSplit = opt.split(" ");
            String command = optSplit[0];
            if ("help".equalsIgnoreCase(command)) {
                help();
            } else if ("load".equalsIgnoreCase(command)) {
                students = load(optSplit[1]);
            } else if ("sort".equalsIgnoreCase(command)) {
                sort(students, optSplit[1]);
            } else if ("select".equalsIgnoreCase(command)) {
                boolean existWhere = false;
                List<String> columns = new ArrayList<>();
                List<String> conditions = new ArrayList<>();
                for (int i = 1; i < optSplit.length; i++) {
                    if (!"where".equalsIgnoreCase(optSplit[i]) && !existWhere) {
                        columns.add(optSplit[i]);
                    } else {
                        existWhere = true;
                        if(!"where".equalsIgnoreCase(optSplit[i]))
                            conditions.add(optSplit[i]);
                    }
                }
                select(students, columns, existWhere, conditions);
            }
        }
    }

    /**
     * 输出帮助信息
     */
    public static void help() {
        System.out.println("--------------------------------\n" +
                "load data.txt\n" +
                "从当刖目录装入文件data .txt,并显示\n" +
                "sort 成绩\n" +
                "按“成绩”排序，并显示\n" +
                "类似地，还可以是 sort 学号,sort 姓名,sort 性别,sort 省份,sort 出生年月等\n" +
                "select 学号 姓名\n" +
                "只显示学号，姓名两列，显示的列还可以其他任意\n" +
                "select 学号 姓名 where 成绩>60\n" +
                "只显示 学号，姓名两列，只包含 成绩>60 的行\n" +
                "select * where 成绩>60 性别=男\n" +
                "显示所有列，只包含成绩>60 且 性别=男 的行\n" +
                "(使用select where时，各条件之间以空格分隔，且各条件内部不得有空格)\n" +
                "其它的组合，从上边类推\n" +
                "exit\n" +
                "退出程序\n" +
                "--------------------------------\n");
    }

    /**
     * 装载指定文件中的数据
     * @param fileName 数据文件路径及文件名
     * @return 文件中的数据转换出的学生列表List< Student>
     */
    public static List<Student> load(String fileName) {
        List<Student> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            br.readLine();
            br.readLine();
            String studentStr = "";
            while ((studentStr = br.readLine()) != null) {
                String[] studentProperties = studentStr.split(" ");
                list.add(new Student(studentProperties[0], studentProperties[1], studentProperties[2], studentProperties[3],
                        new SimpleDateFormat("yyyy-MM-dd").parse(studentProperties[4]), Double.parseDouble(studentProperties[5])));
            }
            System.out.println("装载数据成功！");
            System.out.println("学号\t姓名\t性别\t省份\t出生年月\t\t成绩");
            list.forEach(System.out::println);
            System.out.println();
        } catch (Exception e) {
            System.out.println("装载数据失败！");
        }
        return list;
    }


    /**
     * 根据指定关键字排序
     * @param students 待排序的学生列表
     * @param sortBy 排序关键字
     */
    public static void sort(List<Student> students, String sortBy) {
        switch (sortBy) {
            case "学号":
                students.sort(Comparator.comparing(Student::getId));
                break;
            case "姓名":
                students.sort(Comparator.comparing(Student::getName));
                break;
            case "性别":
                students.sort(Comparator.comparing(Student::getGender));
                break;
            case "省份":
                students.sort(Comparator.comparing(Student::getProvince));
                break;
            case "出生年月":
                students.sort(Comparator.comparing(Student::getBirth));
                break;
            case "成绩":
                students.sort(Comparator.comparing(Student::getScore));
                break;
        }
        System.out.println("排序成功！");
        System.out.println("学号\t姓名\t性别\t省份\t出生年月\t\t成绩");
        students.forEach(System.out::println);
        System.out.println();
    }

    /**
     * 输出属性标题行
     * @param columns 待输出的各属性名
     */
    public static void printColumns(List<String> columns) {
        for (String column : columns) {
            System.out.print(column + "\t");
            if ("出生年月".equals(column))
                System.out.print("\t");
        }
        System.out.println();
    }

    /**
     * 根据指定属性输出学生信息
     * @param student 待输出信息的学生
     * @param columns 指定的各属性
     */
    public static void printSingleStudentByColumns(Student student, List<String> columns){
        for (String column : columns) {
            if ("学号".equals(column)) {
                System.out.print(student.getId() + "\t");
            } else if ("姓名".equals(column)) {
                System.out.print(student.getName() + "\t");
            } else if ("性别".equals(column)) {
                System.out.print(student.getGender() + "\t\t");
            } else if ("省份".equals(column)) {
                System.out.print(student.getProvince() + "\t");
            } else if ("出生年月".equals(column)) {
                System.out.print(new SimpleDateFormat("yyyy-MM-dd").format(student.getBirth()) + "\t");
            } else if ("成绩".equals(column)) {
                System.out.print(student.getScore() + "\t");
            }
        }
        System.out.println();
    }

    /**
     * 查询学生信息
     * @param students 所有学生信息
     * @param columns 待查询的所有属性
     * @param existWhere 是否存在where关键字
     * @param conditions 查询条件
     */
    public static void select(List<Student> students, List<String> columns, boolean existWhere, List<String> conditions) {
        if (columns.size() == 1 && "*".equals(columns.get(0))) {
            columns.clear();
            columns.add("学号");
            columns.add("姓名");
            columns.add("性别");
            columns.add("省份");
            columns.add("出生年月");
            columns.add("成绩");
        }

        if (!existWhere) {
            printColumns(columns);
            for (Student student : students) {
                printSingleStudentByColumns(student, columns);
            }
        } else {
            Map<String, String[]> conditionsMap = new HashMap<>();
            for (String condition : conditions) {
                String[] conditionSplit = condition.split("[<>=]");
                //成绩>60 => {"成绩": [">", "60"]}
                conditionsMap.put(conditionSplit[0], new String[]{condition.substring(conditionSplit.length, condition.indexOf(conditionSplit[1])), conditionSplit[1]});
            }

            printColumns(columns);

            for (Student student : students) {
                boolean validate = true;
                for (String column : columns) {
                    if ("学号".equals(column)) {
                        if (conditionsMap.containsKey("学号")) {
                            String[] condition = conditionsMap.get("学号");
                            switch (condition[0]) {
                                case "<":
                                    if (!(student.getId().compareTo(condition[1]) < 0))
                                        validate = false;
                                    break;
                                case "=":
                                    if (!(student.getId().compareTo(condition[1]) == 0))
                                        validate = false;
                                    break;
                                case ">":
                                    if (!(student.getId().compareTo(condition[1]) > 0))
                                        validate = false;
                                    break;
                            }
                        }
                    } else if ("姓名".equals(column)) {
                        if (conditionsMap.containsKey("姓名")) {
                            String[] condition = conditionsMap.get("姓名");
                            switch (condition[0]) {
                                case "<":
                                    if (!(student.getName().compareTo(condition[1]) < 0))
                                        validate = false;
                                    break;
                                case "=":
                                    if (!(student.getName().compareTo(condition[1]) == 0))
                                        validate = false;
                                    break;
                                case ">":
                                    if (!(student.getName().compareTo(condition[1]) > 0))
                                        validate = false;
                                    break;
                            }
                        }
                    } else if ("性别".equals(column)) {
                        if (conditionsMap.containsKey("性别")) {
                            String[] condition = conditionsMap.get("性别");
                            switch (condition[0]) {
                                case "<":
                                    if (!(student.getGender().compareTo(condition[1]) < 0))
                                        validate = false;
                                    break;
                                case "=":
                                    if (!(student.getGender().compareTo(condition[1]) == 0))
                                        validate = false;
                                    break;
                                case ">":
                                    if (!(student.getGender().compareTo(condition[1]) > 0))
                                        validate = false;
                                    break;
                            }
                        }
                    } else if ("省份".equals(column)) {
                        if (conditionsMap.containsKey("省份")) {
                            String[] condition = conditionsMap.get("省份");
                            switch (condition[0]) {
                                case "<":
                                    if (!(student.getProvince().compareTo(condition[1]) < 0))
                                        validate = false;
                                    break;
                                case "=":
                                    if (!(student.getProvince().compareTo(condition[1]) == 0))
                                        validate = false;
                                    break;
                                case ">":
                                    if (!(student.getProvince().compareTo(condition[1]) > 0))
                                        validate = false;
                                    break;
                            }
                        }
                    } else if ("出生年月".equals(column)) {
                        if (conditionsMap.containsKey("出生年月")) {
                            String[] condition = conditionsMap.get("出生年月");
                            try {
                                switch (condition[0]) {
                                    case "<":
                                        if (!(student.getBirth().compareTo(new SimpleDateFormat("yyyy-MM-dd").parse(condition[1])) < 0))
                                            validate = false;
                                        break;
                                    case "=":
                                        if (!(student.getBirth().compareTo(new SimpleDateFormat("yyyy-MM-dd").parse(condition[1])) == 0))
                                            validate = false;
                                        break;
                                    case ">":
                                        if (!(student.getBirth().compareTo(new SimpleDateFormat("yyyy-MM-dd").parse(condition[1])) > 0))
                                            validate = false;
                                        break;
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    } else if ("成绩".equals(column)) {
                        if (conditionsMap.containsKey("成绩")) {
                            String[] condition = conditionsMap.get("成绩");
                            switch (condition[0]) {
                                case "<":
                                    if (!(student.getScore() < Double.parseDouble(condition[1])))
                                        validate = false;
                                    break;
                                case "=":
                                    if (!(student.getScore() == Double.parseDouble(condition[1])))
                                        validate = false;
                                    break;
                                case ">":
                                    if (!(student.getScore() > Double.parseDouble(condition[1])))
                                        validate = false;
                                    break;
                            }
                        }
                    }
                }
                if (validate) {
                    printSingleStudentByColumns(student, columns);
                }
            }
        }
        System.out.println();
    }
}
