import java.net.URL;

import java.net.URLConnection;

import java.util.Date;



public class Detector {

    private static void keepTomcatAlive() throws NullPointerException {

        String s;

        String t = new String("tomcat6.exe");

        boolean isTomcatAlive = false;

        java.io.BufferedReader in;

        try {

            URL url = new URL("http://localhost:8081/expert_system/mobile/jsp/login/doctor_login.jsp");

            URLConnection con = url.openConnection();

            in = new java.io.BufferedReader(new java.io.InputStreamReader(con

                    .getInputStream()));

            con.setConnectTimeout(1000);

            con.setReadTimeout(4000);

            while ((s = in.readLine()) != null) {

                if (s.length() > 0) {

                    // 如果能够读取到页面则证明可用

                    return;

                }

            }

            in.close();

        } catch (Exception ex) {

        }



        try {

            java.lang.Process p = java.lang.Runtime.getRuntime().exec(

                    "tasklist");



            in = new java.io.BufferedReader(new java.io.InputStreamReader(p

                    .getInputStream()));



            while ((s = in.readLine()) != null) {

                if (s.startsWith(t)) {

                    isTomcatAlive = true;

                    break;

                }

            }

            in.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        if (isTomcatAlive) {

            System.out.println("<" + new Date()

                    + "> Tomcat is alive but not response!");

            stopTomcat();

        }

        startTomcat();

    }



    public static void stopTomcat() {

        try {

            java.lang.Process p = java.lang.Runtime.getRuntime().exec(

                    "shutdown.bat");

            java.io.BufferedReader in = new java.io.BufferedReader(

                    new java.io.InputStreamReader(p.getInputStream()));

            String s;

            String t = "成功停止";

            boolean restart = false;

            while ((s = in.readLine()) != null) {

                if (s.indexOf(t) != -1) {

                    restart = true;

                    break;

                }

            }

            System.out.println("<" + new Date() + "> Tomcat is stop"

                    + (restart ? "OK" : "ERROR"));

        } catch (Exception e) {

            e.printStackTrace();

        }

    }



    public static void startTomcat() {

        try {

            java.lang.Process p = java.lang.Runtime.getRuntime().exec(

                    "startup.bat");

        } catch (Exception e) {

            e.printStackTrace();

        }

        try {

            java.lang.Process p = java.lang.Runtime.getRuntime().exec(

                    "startup.bat");

            java.io.BufferedReader in = new java.io.BufferedReader(

                    new java.io.InputStreamReader(p.getInputStream()));

            String s;

            String t = "启动成功";

            boolean restart = false;

            while ((s = in.readLine()) != null) {

                if (s.indexOf(t) != -1) {

                    restart = true;

                    break;

                }

            }

            System.out.println("<" + new Date() + "> Tomcat is start"

                    + (restart ? "OK" : "ERROR"));

        } catch (Exception e) {

            e.printStackTrace();

        }

    }




}   