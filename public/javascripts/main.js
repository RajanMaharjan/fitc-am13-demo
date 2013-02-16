$(document)
.keydown(function(e) {
    var keyCode = e.keyCode;
    var container = $("#posts");
    var items = container.children();
    var current = items.filter(".current");
    var next;
    var left = keyCode == kendo.keys.LEFT;

    if (keyCode == kendo.keys.RIGHT) {
        // show next picture
        next = current.next();
        if (!next.length) {
            next = items.eq(0);
        }
    } else if (keyCode == kendo.keys.LEFT) {
        // show previous picture
        next = current.prev();
        if (!next.length) {
            next = items.eq(items.length - 1);
        }
    } else {
        // don't handle this key
        return;
    }

    if (container.data("animating")) {
        return;
    }

    current.animate({ opacity: 0 }, "fast");

    container.data("animating", true);

    next.css({
            left: left ? -960 : 960,
            opacity: 1,
            top: 0,
            display: "block",
            position: "absolute"
        })
        .animate({
            left: 0
        }, "fast", function() {
            current.removeClass("current");
            next.addClass("current");
            container.data("animating", false);
        });
});
