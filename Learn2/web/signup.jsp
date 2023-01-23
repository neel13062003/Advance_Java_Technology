<%-- 
    Document   : signup
    Created on : 17 Jan, 2023, 6:45:39 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Signup</title>
         <!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

        <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    </head> 
    <body style="background:url(img/aim.png);background-attachment:fixed;"> <!-- background-size:cover;-->
        <div class="container">
            <div class="row">
                <div class="col m-6 offset-m1" > <!--m3-->   
                    <div class="card">
                        <div class="card-content">
                            <h3 style="margin-top:10px;" class="center-align"> Register Here </h1>
                            
                            <!h5 id="msg" class="center-align"><!--/h5--> <!-- Additioanlly in ajax for -->
                            
                            <div class="form center-align">
                                <!Creating form>
                                <form action="Register" method="POST" id="myForm">
                                    <input type="text" placeholder="Enter Name"  name="user_name" />
                                    <input type="password" placeholder="Enter Password"  name="user_password" />
                                    <input type="email" placeholder="Enter Email"  name="user_email" />
                                    
                                    <!--div class="file-field input-field">
                                        <div class="btn">
                                          <span>File</span>
                                          <input name="image" type="file">
                                        </div>  
                                        <div class="file-path-wrapper">
                                          <input class="file-path validate" type="text">
                                        </div>
                                     </div>
                                    <!input type="file" name="image" size="50"/></td-->
                                    
                                    <button type="submit" class="btn red">Submit</button>     
                                </form>
                            </div>
                            <div class="loader center-align" style="margin-top:10px; display:none;">
                                <div class="preloader-wrapper big active">
                                    <div class="spinner-layer spinner-blue-only">
                                      <div class="circle-clipper left">
                                        <div class="circle"></div>
                                      </div><div class="gap-patch">
                                        <div class="circle"></div>  
                                      </div><div class="circle-clipper right">
                                        <div class="circle"></div>
                                      </div>
                                    </div>
                                </div>
                                <h5> Please Wait... </h5>
                            </div>
                            
                            
                            
                        </div>
                    </div>
                </div>
            </div>   
        </div>
        
        <script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
        <!--------script> <!--This script is checking jqery is working or not -->
            <!---$(document).ready(function(){
                console.log("Page is Ready...")
                
                $("#myForm").on('submit',function(event){
                    event.preventDefault();
                    var f= $(this).serialize();
                    console.log(f);
                    
                    $.(".loader").show();
                    $.(".form").hide();
                    
                    $.ajax({
                        url: "Register",
                        data: f,
                        type: 'POST',
                        success : function(data,textStatus,jqXHR){
                            console.log(data);
                            console.log("success....");
                            $.(".loader").show();
                            $.(".form").hide();
                            if(data.trim()==='Done')
                            {
                                $('msg').html("Successfully Registered...")
                                $('msg').addClass('green-text')
                                
                            }
                            else
                            {
                                $('msg').html("Something Went Wrong on Server...")
                            }
                            
                        },
                        error : function(jqXHR,textStatus,errorThrown){
                            console.log(data);
                            console.log("Error....");
                            $.(".loader").hide();
                            $.(".form").show();
                            $('msg').html("Something Went Wrong on Server...")
                        },
                    })
                })
                
            })---------->
       
    </body>
</html>
