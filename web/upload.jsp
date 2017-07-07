<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <fieldset>
    <legend>文件上传</legend>
    <form action="/upload" method="post" enctype="multipart/form-data">
          <tr>
            <td><input type="file" name="file"></td>
            <td><input type="submit" value="上传"></td>
          </tr>
    </form>
  </fieldset>
  <fieldset>
        <a href="/download">下载</a>
  </fieldset>
  </body>
</html>
