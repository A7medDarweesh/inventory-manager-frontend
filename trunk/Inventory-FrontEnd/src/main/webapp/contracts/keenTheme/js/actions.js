/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function(){
    $(".row_header").click(function (){
     
                $(".row_content").hide(500,"easeOutBack");
                $(this).parent().children(".row_content").show(500,"easeInBack");
            });
            $(".treeview").click(function (){
                if($(this).hasClass("opened")){
                    $(this).children(".treeview-menu").slideUp(700,"easeInOutQuint");
                     $(this).removeClass("opened");
                }else{
                $(".treeview-menu").slideUp(700,"easeInOutQuint");
                $(".treeview").removeClass("opened");
               $(this).children(".treeview-menu").slideDown(700,"easeInOutQuint");
               $(this).addClass("opened");
           }
               
            });
             $(".treeview .opened").click(function (){
               
               
            });
           function openSubMenu (header) {
            var headerJQ = $(header);
            
            if(this.activeSubSubMenu) {
                $(this.activeSubSubMenu).removeClass("openSubMenuLink");
                this.activeSubSubMenu = null;
            }
            
            if(this.activeMenu) {
                if(this.activeMenu === header) {
                    headerJQ.removeClass('MenuSideMainLinkDark').next().slideUp(700,"easeInOutQuint");
                    this.activeMenu = null;
                    $.removeCookie('menustate', {path: '/'});
                }
                else {
                    $(this.activeMenu).removeClass('MenuSideMainLinkDark').next().slideUp(700,"easeInOutQuint");
                    headerJQ.addClass("MenuSideMainLinkDark").next().slideDown(700,"easeInOutQuint");
                    this.activeMenu = header;
                    $.cookie('menustate', headerJQ.attr('id'), {path: '/'});
                }
            }
            else {
                headerJQ.addClass("MenuSideMainLinkDark").next().slideDown(700,"easeInOutQuint");
                this.activeMenu = header;
                $.cookie('menustate', headerJQ.attr('id'), {path: '/'});
            }
        }
        
});
 
        