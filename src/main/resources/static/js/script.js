console.log("this is script file");

const togglesidebar = () => {
    const $sidebar = $(".sidebar");
    const $content = $(".content");

    if ($sidebar.is(":visible")) {
        // Slide up and then hide
        $sidebar.slideUp(200); // 300ms animation
        $content.animate({ marginLeft: "3%" }, 1100);
    } else {
        // Slide down and show
        $sidebar.slideDown(1100);
        $content.animate({ marginLeft: "20%" }, 300);
    }
}


$(document).mouseup(function (e) {
    const $sidebar = $(".sidebar");
    if (!$sidebar.is(e.target) && $sidebar.has(e.target).length === 0 && $sidebar.is(":visible")) {
        $sidebar.slideUp(300);
        $(".content").animate({ marginLeft: "3%" }, 300);
    }
});




// Auto hide alert after 3 seconds
  setTimeout(() => {
    const alertBox = document.getElementById("alertBox");
    if (alertBox) {
      alertBox.style.transition = "opacity 0.5s ease";
      alertBox.style.opacity = "0";
      setTimeout(() => alertBox.remove(), 500); // remove after fade out
    }
  }, 3000);
  
  
  
  
  

  