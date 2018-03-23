const file = `catlaugh.jpg`;
let html = ``;
const videos = [
	{
		title: `CATS will make you LAUGH YOUR HEAD OFF - Funny CAT compilation`,
		thumbnail: `catlaugh.jpg`,
		video: `videos/catfails.mp4`
	},
	{
		title: `Hilarious Cat Fails (April 2017)`,
		thumbnail: `catfails.jpg`,
		video: `videos/catfails.mp4`
	},
	{
		title: `Cats are so funny you will die laughing - Funny cat compilation`,
		thumbnail: `catssofunny.jpg`,
		video: `videos/catfails.mp4`
	}
];

for(let i = 0 ; i<videos.length ;i++){
    html+=`<h2>${videos[i].title}</h2>`;
    html+=`<a href="images/${videos[i].thumbnail}"><img src="images/${videos[i].thumbnail}"></a>`;
}

videos.forEach(function(element) {
    html+=`<h2>${element.title}</h2>`;
    html+=`<a href="images/${element.thumbnail}"><img src="images/${element.thumbnail}"></a>`;
});

html += videos.map(function(element){
    let text = ``;
    text+=`<h2>${element.title}</h2>`;
    text+=`<a href="images/${element.thumbnail}"><img src="images/${element.thumbnail}"></a>`;
    return text;
}).join();

class Component{
    constructor(tag, children) {
        this.tag = tag;
        this.children = children;
    }
    
    renderChildren(){
        let chaine = ``;
        this.children.forEach(function(element) {
           if(element instanceof Component){
               chaine += `${element.render()}`;
           }else if(element instanceof String){
               chaine += `${element}`;
           }
        });
        return chaine;
    }
    
    render(){
        return `<${this.tag}>${this.renderChildren()}</${this.tag}`;
    }
}

class VideoThumbail extends Component{
    constructor(video) {
        super(``,[]);
        this.video = video;
    }
    
    render(){
        return `<div class="thumbnail"><img src="images/${this.video.thumbnail}"><h2>${this.video.title}</h2></div>`;
    }
}

videos.forEach(function(element) {
    html+= new VideoThumbail(element).render();
});

let comp = (new Component(`h1`,[new String(`JSTube`)])).render();
html+=`<br>${comp}`;

document.querySelector(`.container_sec`).innerHTML = html;
console.log(`youpi`);