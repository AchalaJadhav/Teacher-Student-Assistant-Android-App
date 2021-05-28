package com.example.teacherstudentapp;

public class CPP_Quiz_Library {
    private static String myQuestions[] = {
            "How to stop Name Mangling in C++?",
            "Which of the following is Memory Leak detection tool?",
            "Exceptions are Caught at ?",
            "What is the size of empty class?",
            "What is abstract class?",
            "How many object can be created of a Class in C++?",
            "When Virtual Table is created?",
            "#include<iostream>\n" +
                    "using namespace std;\n" +
                    "\n" +
                    "int main()\n" +
                    "{\n" +
                    "\n" +
                    "cout<<-1-1-1;\n" +
                    "\n" +
                    "return 0;\n" +
                    "}",
            "#include <iostream>\n" +
                    "using namespace std;\n" +
                    "\n" +
                    "class X\n" +
                    "{\n" +
                    "public: X()\n" +
                    "        { cout<<\"X\"; }\n" +
                    "        ~X()\n" +
                    "        { cout<<\"~X\"; }\n" +
                    "};\n" +
                    "\n" +
                    "class Y : public X\n" +
                    "{\n" +
                    "public: Y()\n" +
                    "        { cout<<\"Y\"; }\n" +
                    "        ~Y()\n" +
                    "        { cout<<\"~Y\"; }\n" +
                    "};\n" +
                    "\n" +
                    "int main()\n" +
                    "{\n" +
                    "    Y obj;\n" +
                    "    return 0;\n" +
                    "}",
            "class Mycpp\n" +
                    "{\n" +
                    "    \n" +
                    "};\n" +
                    "\n" +
                    "int main()\n" +
                    "{\n" +
                    "    Mycpp obj;\n" +
                    "    return 0;\n" +
                    "}"
    };

    private static String myChoice[][] = {
            {"It is not possible","It is possible only with C code" ,"By using extern \"C\" keyword","By Converting C++ code to C"},
            {"GC++","KDevelop","GIT","Valgrind"},
            {"Compilation Time","Run Time","Linking Time","No"},
            {"0","1","2","4"},
            {"A class with abstract keyword","A class with no functions in it","A class with atleast one pure virtual function","Empty Class"},
            {"1", "5","There is no limit",       "256"},
            {"Every Class has VTable","Class inherited from other Class","When a Class Overrides the function of Base class","Class has atleast one Virtual Function"},
            {"Compilation Error","0","3","-3"},
            {"XY~X~Y","XY~Y~X","X~XY~Y","X~X~YY"},
            {"Compilation Error - Constructor Missing","Nothing would be printed","Undefined","In constructor"}

    };

    private static String mCorrectAnswers[] = {
            "By using extern \"C\" keyword",
            "Valgrind",
            "Run Time",
            "1",
            "A class with atleast one pure virtual function",
            "There is no limit",
            "Class has atleast one Virtual Function",
            "-3",
            "XY~Y~X",
            "Nothing would be printed"


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

