/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
   
   $("#compose-button").on('click',function(){
       $("#messagelist").hide();
       $("#compose").show();
   })
   
   $("#inbox").on('click',function(){
       $("#compose").hide();
       $("#messagelist").show();
   })
   
   
})