(function( $ ) {
 
    $.fn.validate = function(regex) {
         this.each(function() {
            var elem = $( this );
            console.log(elem.text());
            if(regex.test(elem.text())){
                elem.css("background-color", "blue")
            }
            else {
                elem.css("background-color", "red")
            }
        });
         return this;
     };
 
}( jQuery ));
