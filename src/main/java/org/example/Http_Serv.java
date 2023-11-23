package org.example;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class Http_Serv {

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8085),0);
        server.createContext("/", new Handler("/"));
        server.createContext("/about-us", new Handler("/about-us"));
        server.createContext("/contact", new Handler("/contact"));
        server.createContext("/services", new Handler("/services"));
        server.setExecutor(null);
        server.start();

    }

    static class Handler implements HttpHandler {
        private String path;

        public Handler(String path) {
            this.path = path;
        }

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response;
            System.out.println("This is the current path "+path);
            if (Objects.equals(path.length(), 1)){
                response = "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <title>HomePage</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
"<ul style=\"margin-right: 2rem; margin-left: auto; display: flex; justify-content: space-around; list-style: none; width: 400px;\">\n "+
                        "                 <li><a style=\"color: #33323D; font-family: 'Public Sans'; font-size: 13px; font-style: normal; font-weight: 400; line-height: normal; letter-spacing: 2px; text-transform: uppercase; text-decoration: underline;\" href = "+"/>Home</a></li>\n"+
                        "                 <li><a  style=\"color: #33323D; font-family: 'Public Sans'; font-size: 13px; font-style: normal; font-weight: 400; line-height: normal; letter-spacing: 2px; text-transform: uppercase; text-decoration: underline\" href = "+"/about-us>About Us</a></li>\n"+
                        "                 <li><a  style=\"color: #33323D; font-family: 'Public Sans'; font-size: 13px; font-style: normal; font-weight: 400; line-height: normal; letter-spacing: 2px; text-transform: uppercase; text-decoration: underline;\" href = "+"/contact>Contact</a></li>\n"+
                        "                 <li><a style=\"color: #33323D; font-family: 'Public Sans'; font-size: 13px; font-style: normal; font-weight: 400; line-height: normal; letter-spacing: 2px; text-transform: uppercase; text-decoration: underline;\"  href = "+"/services>Services</a></li>\n"+
                        "                  </ul>\n "+
                        "<br>" +
                        "<h1>TRADE AND INVESTMENT PROMOTION</h1>"+
                        "<br>"+
                        "<h2>WELCOME!</h2>\n"+
                        "<p> Fast-growing finance for the individual who dream. <b>We're transforming financial system to empower every individual to unlock their complete potential</p>"+

                        "<img src="+"https://tradeandinvestmentpromotion.com/wp-content/uploads/2019/01/SAP.jpg />"+
                        "<br>"+
                        "</body>\n" +
                        "</html>";
            } else if (path.contains("/about-us")) {
                response = "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <title>HomePage</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "<ul style=\"margin-right: 2rem; margin-left: auto; display: flex; justify-content: space-around; list-style: none; width: 400px;\">\n "+
                        "                 <li><a style=\"color: #33323D; font-family: 'Public Sans'; font-size: 13px; font-style: normal; font-weight: 400; line-height: normal; letter-spacing: 2px; text-transform: uppercase; text-decoration: underline;\" href = "+"/>Home</a></li>\n"+
                        "                 <li><a  style=\"color: #33323D; font-family: 'Public Sans'; font-size: 13px; font-style: normal; font-weight: 400; line-height: normal; letter-spacing: 2px; text-transform: uppercase; text-decoration: underline\" href = "+"/about-us>About Us</a></li>\n"+
                        "                 <li><a  style=\"color: #33323D; font-family: 'Public Sans'; font-size: 13px; font-style: normal; font-weight: 400; line-height: normal; letter-spacing: 2px; text-transform: uppercase; text-decoration: underline;\" href = "+"/contact>Contact</a></li>\n"+
                        "                 <li><a style=\"color: #33323D; font-family: 'Public Sans'; font-size: 13px; font-style: normal; font-weight: 400; line-height: normal; letter-spacing: 2px; text-transform: uppercase; text-decoration: underline;\"  href = "+"/services>Services</a></li>\n"+
                        "                  </ul>\n "+
                        "<br>" +
                        "<p>Trade and Investment Promotion is a consulting company and a digital platform inspired by the need to create a better connected world of trade and investment promotion professionals.\n" +
                        "\n" +
                        "Browsing through our pages gives you the following unique insights in a single digital location:\n" +
                        "\n" +
                        "New investment and trade measures implemented by countries of your interest,\n" +
                        "Latest trade and investment promotion practices,\n" +
                        "Interviews with peers,\n" +
                        "Development of new digital tools,\n" +
                        "Academic research on investment and trade, as well as other relevant updates.</p>"+
                        " <img src=\"https://tradeandinvestmentpromotion.com/wp-content/uploads/2021/11/61st_ETPO_Conference_in_Athens-_Family_photo-696x464.jpg\" alt=\"Conference in Athens\" style=\"padding: 20px; border: 2px solid #ddd; border-radius: 8px;\">"+

                        "<br>" +
                        "<b>Enterprise Greece, the official agency of the Greek State that promotes exports and attracts " +
                        "foreign direct investment, hosted the 61st Conference of the European Trade Promotion Organisations (ETPO)" +
                        " <br>"+
                        "</body>\n" +
                        "</html>";
            }else if (path.contains("/contact")) {
                response = "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <title>HomePage</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "<ul style=\"margin-right: 2rem; margin-left: auto; display: flex; justify-content: space-around; list-style: none; width: 400px;\">\n "+
                        "                 <li><a style=\"color: #33323D; font-family: 'Public Sans'; font-size: 13px; font-style: normal; font-weight: 400; line-height: normal; letter-spacing: 2px; text-transform: uppercase; text-decoration: underline;\" href = "+"/>Home</a></li>\n"+
                        "                 <li><a  style=\"color: #33323D; font-family: 'Public Sans'; font-size: 13px; font-style: normal; font-weight: 400; line-height: normal; letter-spacing: 2px; text-transform: uppercase; text-decoration: underline\" href = "+"/about-us>About Us</a></li>\n"+
                        "                 <li><a  style=\"color: #33323D; font-family: 'Public Sans'; font-size: 13px; font-style: normal; font-weight: 400; line-height: normal; letter-spacing: 2px; text-transform: uppercase; text-decoration: underline;\" href = "+"/contact>Contact</a></li>\n"+
                        "                 <li><a style=\"color: #33323D; font-family: 'Public Sans'; font-size: 13px; font-style: normal; font-weight: 400; line-height: normal; letter-spacing: 2px; text-transform: uppercase; text-decoration: underline;\"  href = "+"/services>Services</a></li>\n"+
                        "                  </ul>\n "+
                        "<br>" +
                        "<h1> CONTACT</h1>"+
                        "<br><br>"+ "<b> TRADE AND INVESTMENT PROMOTION DIGITAL PLATFORM"+
                        "<br>" + "<p a href=> Email: sobowaleomotayo97@gmail.com</a></p>" +
                        "<br>" + "<p> Linkedln : Trade and Investment Promotion</p>"+
                        "<br>"+ "<img src=\"https://www.linkedin.com/in/trade-and-investment-promotion>"+
                        "<br>"+ "<img src=\"https://twitter.com/PromotionTrade>"+
                        "<br>"+
                        "</body>\n" +
                        "</html>";
            }else if (path.contains("/service")) {
                response = "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        " <meta charset=\"UTF-8\">\n" +
                        "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                        "    <title>HomePage</title>\n" +
                        "  <style>\n" +
                        "    /* Apply some basic styling for better presentation */\n" +
                        "    body {\n" +
                        "      font-family: Arial, sans-serif;\n" +
                        "      margin: 0;\n" +
                        "      padding: 0;\n" +
                        "      display: flex;\n" +
                        "      justify-content: space-around;\n" +
                        "      align-items: bottom-left;\n" +
                        "      height: 100vh;\n" +
                        "      background-color: #f4f4f4;\n" +
                        "    }\n" +
                        "\n" +
                        "    /* Apply styling to the form container */\n" +
                        "    .form-container {\n" +
                        "      background-color: #fff;\n" +
                        "      padding: 20px;\n" +
                        "      border-radius: 8px;\n" +
                        "      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\n" +
                        "    }\n" +
                        "\n" +
                        "    /* Apply styling to the form buttons */\n" +
                        "    .form-container button {\n" +
                        "      background-color: #4CAF50;\n" +
                        "      color: #fff;\n" +
                        "      padding: 10px 20px;\n" +
                        "      border: none;\n" +
                        "      border-radius: 4px;\n" +
                        "      cursor: pointer;\n" +
                        "    }\n" +
                        "\n" +
                        "    /* Apply spacing between forms */\n" +
                        "    .form-container:not(:last-child) {\n" +
                        "      margin-bottom: 20px;\n" +
                        "    }\n" +
                        "  </style>"+

                        "</head>\n" +
                        "<body>\n" +


                        "<ul style=\"margin-right: 2rem; margin-left: auto; display: flex; justify-content: space-around; list-style: none; width: 400px;\">\n "+
                        "                 <li><a style=\"color: #33323D; font-family: 'Public Sans'; font-size: 13px; font-style: normal; font-weight: 400; line-height: normal; letter-spacing: 2px; text-transform: uppercase; text-decoration: underline;\" href = "+"/>Home</a></li>\n"+
                        "                 <li><a  style=\"color: #33323D; font-family: 'Public Sans'; font-size: 13px; font-style: normal; font-weight: 400; line-height: normal; letter-spacing: 2px; text-transform: uppercase; text-decoration: underline\" href = "+"/about-us>About Us</a></li>\n"+
                        "                 <li><a  style=\"color: #33323D; font-family: 'Public Sans'; font-size: 13px; font-style: normal; font-weight: 400; line-height: normal; letter-spacing: 2px; text-transform: uppercase; text-decoration: underline;\" href = "+"/contact>Contact</a></li>\n"+
                        "                 <li><a style=\"color: #33323D; font-family: 'Public Sans'; font-size: 13px; font-style: normal; font-weight: 400; line-height: normal; letter-spacing: 2px; text-transform: uppercase; text-decoration: underline;\"  href = "+"/services>Services</a></li>\n"+
                        "                  </ul>\n "+



                "<br>"+
                        "<div class=\"form-container\">\n" +
                        "    <h2>SECURE HORIZONS</h2>\n" +
                        "    <p>7% After 24 Hours</p>\n" +
                        "    <p>Minimum Deposit: $50</p>\n" +
                        "    <p>Maximum Deposit: $599</p>\n" +
                        "    <p>Duration: 24 Hours</p>\n" +
                        "    <p>Referral Bonus: 3%</p>\n" +
                        "    <button>Invest Now</button>\n" +
                        "  </div>\n" +
                        "\n" +
                        "  <!-- Form 2: INFINITE RETURNS -->\n" +
                        "  <div class=\"form-container\">\n" +
                        "    <h2>INFINITE RETURNS</h2>\n" +
                        "    <p>14% After 24 Hours</p>\n" +
                        "    <p>Minimum Deposit: $500</p>\n" +
                        "    <p>Maximum Deposit: $4,999</p>\n" +
                        "    <p>Duration: 24 Hours</p>\n" +
                        "    <p>Referral Bonus: 5%</p>\n" +
                        "    <button>Invest Now</button>\n" +
                        "  </div>\n" +
                        "\n" +
                        "  <!-- Form 3: CAPITAL GROWTH -->\n" +
                        "  <div class=\"form-container\">\n" +
                        "    <h2>CAPITAL GROWTH</h2>\n" +
                        "    <p>21% Daily For 24 Hours</p>\n" +
                        "    <p>Minimum Deposit: $5,000</p>\n" +
                        "    <p>Maximum Deposit: $9,000</p>\n" +
                        "    <p>Duration: 48 Hours</p>\n" +
                        "    <p>Referral Bonus: 7%</p>\n" +
                        "    <button>Invest Now</button>\n" +
                        "  </div>\n" +
                        "\n" +
                        "  <!-- Form 4: DIVERSIFIED WEALTH -->\n" +
                        "  <div class=\"form-container\">\n" +
                        "    <h2>DIVERSIFIED WEALTH</h2>\n" +
                        "    <p>30% After 48 Hours</p>\n" +
                        "    <p>Minimum Deposit: $10,000</p>\n" +
                        "    <p>Maximum Deposit: UNLIMITED</p>\n" +
                        "    <p>Duration: 24 Hours</p>\n" +
                        "    <p>Referral Bonus: 10%</p>\n" +
                        "    <button>Invest Now</button>\n" +
                        "  </div>"+
                        "</body>\n" +
                        "</html>";
            }
            else{
                response =  "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <title>HomePage</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "<h1> 404 Page Not Found</h1>\n" +
                        "<a href = "+"localhost"+":8085/about-us>About Us</a>\n"+
                        "<a href = "+"localhost"+":8085/>Home page</a>\n"+
                        "</body>\n" +
                        "</html>";
            }


            exchange.getResponseHeaders().set("Content-type","text/html");
            exchange.sendResponseHeaders(200, response.length());
            try(OutputStream outputStream = exchange.getResponseBody()){
                outputStream.write(response.getBytes(StandardCharsets.UTF_8));
            }
        }
    }

}
