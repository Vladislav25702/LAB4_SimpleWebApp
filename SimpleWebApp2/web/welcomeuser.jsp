
<%@ page import="com.mysql.*" %>
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sections</title>
</head>
<body>
<div id="content">


    <p>Displaying table contents: </p>

    <table border="0" cellpadding="10">
        <thead>
        <tr>
            <th>Section_Id</th>
            <th>Section</th>
        </tr>
        </thead>
        <tbody>


        <%
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = null;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "password");
            Statement stmt = null;
            stmt = conn.createStatement();
            String query = "select * from sections";
            ResultSet rs = null;
            rs = stmt.executeQuery(query);
            while(rs.next()){
        %>
        <tr>
            <%
                Long id = rs.getLong("Section_Id");
                String name = rs.getString("Section");
            %>
            <td><%=id %></td>
            <td><%=name %></td>
        </tr>

        <%
            }
        %>

        </tbody>
    </table>
</div>
</body>
</html>
