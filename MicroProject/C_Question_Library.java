package com.example.teacherstudentapp;

public class C_Question_Library {
    private static String myQuestions[] = {
            "How many main() function we can have in our project?",
            "What is sizeof() in C?",
            "int main()\n" +
                    "{\n" +
                    "extern int i;\n" +
                    "i = 20;\n" +
                    "printf(\"%d\", sizeof(i));\n" +
                    "return 0;\n" +
                    "}\n",
            "int main()\n" +
                    "{\n" +
                    "     int x = 10;\n" +
                    "\t{\n" +
                    "\t    int x = 0;\n" +
                    "\t    printf(\"%d\",x);\n" +
                    "\t}\n" +
                    "    return 0;\n" +
                    "}",
            "int x = 10;\n" +
                    "\n" +
                    "int main()\n" +
                    "{\n" +
                    "    int x = 0;\n" +
                    "    printf(\"%d\",x);\n" +
                    "    return 0;\n" +
                    "}",
            "int main()\n" +
                    "{\n" +
                    "\n" +
                    "char *ptr1, *ptr2;\n" +
                    "printf(\"%d %d\", sizeof(ptr1), sizeof(ptr2));\n" +
                    "\n" +
                    "return 0;\n" +
                    "} ",
            "Which programming language is more faster among these?",
            "int main()\n" +
                    "{ \n" +
                    "    int a = printf (\"CppBuzz.com\");\n" +
                    "    printf(\"%d\", a);\n" +
                    "    return 0;\n" +
                    "}",
            "What should be the output:\n" +
                    "int main()\n" +
                    "{ \n" +
                    "    int a = 10/3;\n" +
                    "    printf(\"%d\",a); \n" +
                    "    \n" +
                    "    return 0;\n" +
                    "}",
            "Which of the following is executed by Preprocess?",
            "int main()\n" +
                    "{\n" +
                    "    int a = 10.5;\n" +
                    "    printf(\"%d\",a);\n" +
                    "    return 0;\n" +
                    "}",
            "int main()\n" +
                    "{\n" +
                    "\tint _ = 10;\n" +
                    "\tint __ = 20;\n" +
                    "\tint ___ = _ + __;\n" +
                    "\tprintf(\"__%d\",___);\n" +
                    "\treturn 0;\n" +
                    "}",
            "int main()\n" +
                    "{\n" +
                    "    int a = 5;\n" +
                    "    int b = 10;\n" +
                    "    int c = a+b;\n" +
                    "    printf(\"%i\",c);\n" +
                    "}",
            "int main()\n" +
                    "{\n" +
                    "    char arr[5]=\"The CppBuzz.com\";\n" +
                    "    printf(\"%s\",arr);\n" +
                    "    return 0;\n" +
                    "}",
            "int main()\n" +
                    "{\n" +
                    "    int a = 320;\n" +
                    "    char *ptr;\n" +
                    "    ptr =( char *)&a;\n" +
                    "    printf(\"%d\",*ptr);\n" +
                    "    return 0;\n" +
                    "}",
            "int main()\n" +
                    "{\n" +
                    "    int x;\n" +
                    "    x=10,20,30;\n" +
                    "    printf(\"%d\",x);\n" +
                    "    return 0;\n" +
                    "}",
            "How many times CppBuzz.com is printed?\n" +
                    "int main()\n" +
                    "{\n" +
                    "int a = 0;\n" +
                    "while(a++ < 5-++a)\n" +
                    "printf(\"CppBuzz.com\");\n" +
                    "return 0;\n" +
                    "}",
            "",
            "",
            ""
    };

    private static String myChoice[][] = {
            {"1",",2","No Limit","Depends on Compiler"},
            {"Operator","Function","Macro","None of these"},
            {"20","0","Undefined reference to i","Linking Error"},
            {"10","Compilation Error","0","Undefined"},
            {"10","0","Compilation Error","Undefined"},
            {"1 1","2 2","4 4","Undefined"},
            {"Java","PHP","C","Visual Basic"},
            {"Compilation Error","0","CppBuzz.com","CppBuzz.com11"},
            {"3.33","3.0","3","0"},
            {"#include<stdio.h>","return 0","void main(int argc , char ** argv)","None of above"},
            {"10.5","10","0","Compilation Error"},
            {"Compilation Error","Runtime Error", "__0",  "__30"},
            {" 0","15", "Undefined i",     "Any other Compiler Error"},
            {"The CppBuzz.com","The C","The CppBuzz","Compilation Error"},
            {"320",  "60", "160","64"},
            {"10","20","30","Compilation Error"},
            {"5 times","4 times","2 times","1 time"}
    };

    private static String mCorrectAnswers[] = {
            "1",
            "Operator",
            "Undefined reference to i",
            "0",
            "0",
            "4 4",
            "C",
            "CppBuzz.com11",
            "3",
            "#include<stdio.h>",
            "10",
            "__30",
            "15",
            "Compilation Error",
            "64",
            "10",
            "1 time"
    };

    public static String getQuestion(int a){
        String question = myQuestions[a];
        return question;
    }

    public static String getChoice1(int a){
        String choice0 = myChoice[a][0];
        return choice0;
    }

    public static String getChoice2(int a){
        String choice2 = myChoice[a][1];
        return choice2;
    }

    public static String getChoice3(int a){
        String choice3 = myChoice[a][2];
        return choice3;
    }

    public static String getChoice4(int a){
        String choice4 = myChoice[a][3];
        return choice4;
    }

    public static String getCorrectAnswer(int a){
        String answer = mCorrectAnswers[a];
        return answer;
    }
}

