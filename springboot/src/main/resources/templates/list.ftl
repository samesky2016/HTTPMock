    <!DOCTYPE html>  
    <html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"  
          xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">  
        <head>  
            <title>Hello World!</title>  
        </head>  
        <body>  
           <p>  
               Spring boot 发布的接口列表  
           </p>        
            
            
           <h4>列表：</h4>  
           <#list methodList as item>  
               item  
               <br>  
           </#list>  
            
        </body>  
    </html>  