var Image = require('ascii-art-image');

var image = new Image({
    filepath: 'client/public/images/planet.jpeg',
    alphabet: 'variant4'
});

image.write(function(err, rendered){
    console.log(rendered);
})

