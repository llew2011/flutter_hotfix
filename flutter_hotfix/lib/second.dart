import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class SecondPage extends StatefulWidget {

  @override
  State<StatefulWidget> createState() {
    return _SecondState();
  }

}

class _SecondState extends State<SecondPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('标题'),
      ),
      body: Container(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Image.network("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1579773019094&di=f789376555c08468a2508ea5a8e80bbf&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2018-08-01%2F5b618074d8c53.jpg",
              width: 400,
              height: 300,
            ),
            Text("这里是新添加的页面")
          ],
        ),
      ),
    );
  }
}
