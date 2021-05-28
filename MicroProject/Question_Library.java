package com.example.teacherstudentapp;

public class Question_Library {
    private static String myQuestions[] = {
            "Which object of HttpSession can be used to view and manipulate information about a session?",
            "In RMI Architecture which layer Intercepts method calls made by the client/redirects these calls to a remote RMI service?",
            "Which case of a session bean obtains the UserTransaction object via the EJBContext using " +
                    "the getUserTransaction() method in EJB transaction management?",
            "Which services are provided to EJB components by the EJB container?",
            "Which is an object, acts as a gateway for the client side, all the outgoing requests are " +
                    "routed through it and it resides at the client side and represents the remote object?",
            "Predict the output of following Java Programs.",
            "Which attribute specifies a JSP page that should process any exceptions thrown but not caught in the current page?",
            "What technique is used for the authentication mechanism in the servlet specification?",
            "How many Result sets available with the JDBC 2.0 core API?",
            "Which method is used for retrieving streams of both ASCII and Unicode characters is new in the JDBC 2.0 core API?",
            "Which JDBC type represents a \"single precision\" floating point number that supports seven digits of mantissa?",
            " In order to transfer data between a database and an application written in the Java programming language, the JDBC API provides which of these methods?",
            "Which are the common security restrictions in applets?",
            "An applet can play an audio file represented by the AudioClip interface in the java, applet package Causes the audio clip to replay continually in which method?",
            "The following example shows the creation of a\n" +
                    "import java.applet.*;\n" +
                    "import java.awt.*;\n" +
                    "\n" +
                    "public class Main extends Applet{\n" +
                    "public void paint(Graphics g){\n" +
                    "g.drawString(\"Welcome in Java Applet.\",40,20);\n" +
                    "}\n" +
                    "}",
            "In Servlet Terminology what provides runtime environment for JavaEE (j2ee) applications. It performs many operations that are given below:\n" +
                    "\n" +
                    "1. Life Cycle Management\n" +
                    "2. Multithreaded support\n" +
                    "3. Object Pooling\n" +
                    "4. Security etc.",
            "Which is the container that doesn't contain title bar and MenuBars but it can have other components like button, textfield etc?",
            "Where are the following four methods commonly used?",
            "Which method when implemented must return true while there are still more elements to extract, and false when all the elements have been enumerated?",
            "The following Syntax is used for?\n" +
                    "\n" +
                    "class Subclass-name extends Superclass-name\n" +
                    "{\n" +
                    "//methods and fields\n" +
                    "} ",
            "From the following statements which is a disadvantage of an java array?",
            "Which method returns the interrupted flag after that it sets the flag to false if it is true?",
            "Struts supports which of these model components?",
             "Abbreviate the term POJO?",
            "Which is a mechanism where one object acquires all the properties and behaviors of the parent object?",
            "What is the range of the int data type?",
            "Which are subclasses of FilterInputStream and FilterOutputStream?",
            "Which method returns a reference to the currently executing thread object?",
            "Which keyword is used to make the classes and interface of another package accessible to the current package?",
            "Which access specifiers can be used for a class so that it’s members can be accessed by a different class in the different package?",
            "Which is a superclass of all exception classes?"

    };

    private static String myChoice[][] = {
            {"session identifier","creation time","last accessed time","All mentioned above"},
            {"Stub & Skeleton Layer ","Application Layer","Remote Reference Layer","Transport Layer"},
            {"Bean-managed transactions","Container-managed transactions","Both A & B","None of the above"},
            {"Transaction support"," Persistence support","Naming support","All mentioned above"},
            {"Stub","Skeleton","Both A & B","None of the above"},
            {"The ErrorPage Attribute","The IsErrorPage Attribute","Both A & B","None of the above"},
            {"Role Based Authentication","Form Based Authentication","Both A & B","None of the above"},
            {"Unified Data Access","Universal Data Access","Universal Digital Access","Uniform Data Access"},
            {"2","3","4","5"},
            {"getCharacterStream","getBinaryStream","getAsciiStream","getUnicodeStream"},
            {"REAL","DOUBLE","FLOAT","INTEGER"},
            {"Methods on the ResultSet class for retrieving SQL SELECT results as Java types.","Methods on the PreparedStatement class for sending Java types as SQL statement parameters.","Methods on the CallableStatement class for retrieving SQL OUT parameters as Java types.","All mentioned above"},
            {"Applets can't load libraries or define native methods","An applet can't read every system property","Applets can play sounds","Both A & B"},
            {"public void play()","public void loop()","public void stop()","None of the above"},
            {"Banner using Applet","Basic Applet","Display clock","None of the above"},
            {"Server","Webserver","Container"," Application Server"},
            {"Window","Frame","Panel ","Container"},
            {"public void add(Component c)","public void setSize(int width,int height)","public void setLayout(LayoutManager m)","public void setVisible(boolean)"},
            {"Object nextElement( )","boolean hasMoreElements( )","Both A & B","None of the above"},
            {"Polymorphism","Encapsulation","Inheritance","None of the above"},
            {"An array can hold primitive types data","An array has its size that is known as array length","An array knows only its type that it contains. Array type is checked at the compile-time","An array holds only one type of data"},
            {"isInterrupted()","static interrupted()","non static interrupted()","Both A & C"},
            {"JavaBeans","EJB","CORBA","All Mentioned above"},
            {"Plain Old Java Object","Performance Old Java Object","Performance Optimize Java Object","None of the above"},
            {"Inheritance","Encapsulation","Polymorphism","None of the above"},
            {"–2,147,483,648 to 2,147,483,647","-2,147,483,647 to 2,147,483,648","-32,768 to 32,767","-32,767 to 32,768"},
            {"PipedInputStream","DataInputStream","DataOutputStream","Both B & C"},
            {"currentThread()","runningThread()","runnableThread()","d. None of the above"},
            {"Import","Implements","Instanceof","None of the above"},
            {"Private","Public","Protected","None of the above"},
            {"Throwable","Exception","RuntimeException","IOException"}
    };

    private static String mCorrectAnswers[] = {
            "All mentioned above","Stub & Skeleton Layer ","Bean-managed transactions","All mentioned above","Stub","The ErrorPage Attribute",
            "Role Based Authentication","Universal Data Access","3","getCharacterStream",
            "REAL",
            "All mentioned above",
            "Both A & B",
            "public void loop()",
            "Basic Applet",
            "Container",
            "Panel",
            "Component class",
            "boolean hasMoreElements( )",
            "Inheritance",
            "An array holds only one type of data",
            "static interrupted()",
            "All Mentioned above",
            "Plain Old Java Object",
            "Inheritance",
            "–2,147,483,648 to 2,147,483,647",
            "Both C & D",
            "currentThread()",
            "Import",
            "Public",
            "Throwable"
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
