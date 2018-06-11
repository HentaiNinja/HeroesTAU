describe("validate", function () {
    jasmine.clock().install();

    beforeEach(function () {
        //let s = spyOn(console, 'log').and.callThrough();
        $('body').append(`
        <div id="number">Numer</div>
        <div id="text">Tekst</div>
        <div id="a1" class="val">9Tt</div>
        <div id="a2" class="val">%Az</div>
        `);
    });

    afterEach(function () {
        $('#number').remove();
        $('#text').remove();
        $('#a1').remove();
        $('#a2').remove();
    });

    it("invalid text", function () {
        $('#number').validate(/^[0-9]+/);
        expect($('#number').css("background-color")).toEqual("rgb(255, 0, 0)");
    });

    it("text correct", function () {
        $('#text').validate(/^[A-Z][a-z]+/);
        expect($('#text').css("background-color")).toEqual("rgb(0, 0, 255)");
    });


    it("text is somewhat correct", function () {
    $('.val').validate(/^[0-9][A-Z][a-z]/g);
        expect($('#a1').css("background-color")).toEqual("rgb(0, 0, 255)");
        expect($('#a2').css("background-color")).toEqual("rgb(255, 0, 0)");
    });

});