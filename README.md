## This is a full JavaFX Radial menu Widget.
![Radial menu](radialmenu.png)
![Radial menu 2](radialmenu2.png)
### How to use it ?

``` java
RadialMenuContainer root1 = new RadialMenuContainer();
ImageView root1Image = new ImageView(new Image("root1.png"));
root1.setImage(root1Image);

RadialMenuItem root1SubItem1 = new RadialMenuItem();
ImageView root1SubItem1Image = new ImageView(new Image("root1.png"));
root1SubItem1.setImage(root1SubItem1Image);
RadialMenuItem root1SubItem2 = new RadialMenuItem();
RadialMenuItem root1SubItem3 = new RadialMenuItem();
RadialMenuItem root1SubItem4 = new RadialMenuItem();

root1.addItem(root1SubItem1);
root1.addItem(root1SubItem2);
root1.addItem(root1SubItem3);
root1.addItem(root1SubItem4);
```

### How to launch the example ?

``` bash
./gradlew run
```
### Update to come ?
<ul>
     <li> Text in items </li>
     <li> Radial separator </li>
     <li> Center items on top of their parent </li>
     <li> Animations </li>
</ul>

### Questions ?
If you have some questions or recommendations, contact me at jordan.mens@gmail.com