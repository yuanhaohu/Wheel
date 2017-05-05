# Wheel
## 安卓自定义WheelView

![image](https://github.com/yuanhaohu/Wheel/blob/master/图1.jpg)
![image](https://github.com/yuanhaohu/Wheel/blob/master/图2.jpg)
![image](https://github.com/yuanhaohu/Wheel/blob/master/图3.jpg)

## How to use

### layout:

```Java
<com.hyh.mywheelview.MyWheelView
                android:id="@+id/wheelView"
                android:layout_width="match_parent"
                android:layout_height="wrap_content" />
```
### Activiy

#### 有条目背景
```Java
String temp[] = new String[]{"2","4","6","8","10","12","14","16","18","20"};
        MyWheelView wheelView = (MyWheelView) findViewById(R.id.myWheelView);
        wheelView.setOffset(2);//设置item显示条数2n+1
        wheelView.setItemViewBackground(R.color.colorAccent,R.color.colorPrimary);//设置条目颜色,默认无
        wheelView.setItemViewTextColor(R.color.white, R.color.colorAccent);//设置条目字体颜色，默认黑灰
        wheelView.setItemViewTextSize(30,20);//设置条目字体大小,默认15
        wheelView.setSeletion(0);//默认选择条目
        wheelView.setItems(Arrays.asList(temp));//添加数据源吧

        wheelView.setOnWheelViewListener(new MyWheelView.OnWheelViewListener() {
            @Override
            public void onSelected(int selectedIndex, String item) {
                Log.e("select",item);
            }
        });
```	
#### 有分隔线
```Java
String temp[] = new String[]{"2","4","6","8","10","12","14","16","18","20"};
        MyWheelView wheelView = (MyWheelView) findViewById(R.id.myWheelView);
        wheelView.setOffset(2);//设置item显示条数2n+1
        wheelView.setItemViewTextColor(R.color.colorPrimary, R.color.colorAccent);//设置条目字体颜色，默认黑灰
        wheelView.setItemViewTextSize(30,20);//设置条目字体大小,默认15
        wheelView.setSeletion(0);//默认选择条目
        wheelView.setHaveLine(true);//是否有分隔线,无法和条目背景颜色方法同时设置
        wheelView.setLineHeight(10);//分隔线高度
        wheelView.setLineWidth(30,30);//分隔线左右间距
        wheelView.setLineColor(R.color.colorAccent);//分隔线颜色
        wheelView.setItems(Arrays.asList(temp));//添加数据源吧

        wheelView.setOnWheelViewListener(new MyWheelView.OnWheelViewListener() {
            @Override
            public void onSelected(int selectedIndex, String item) {
                Log.e("select",item);
            }
        });
```
#### 有分隔线
```Java
dialog = new Dialog(this);
        String temp[] = new String[]{"2","4","6","8","10","12","14","16","18","20"};
//        final AlertDialog.Builder builder= new AlertDialog.Builder(this);
        View rootView = View.inflate(this, R.layout.view_wheelview, null);
        MyWheelView wheelView = (MyWheelView) rootView.findViewById(R.id.wheelView);
        wheelView.setOffset(1);
        wheelView.setItems(Arrays.asList(temp));
        wheelView.setSeletion(0);
        wheelView.setHaveLine(false);

        wheelView.setOnWheelViewListener(new MyWheelView.OnWheelViewListener() {
            @Override
            public void onSelected(int selectedIndex, String item) {
                itemString = item;
            }
        });

        TextView quxiao = (TextView) rootView.findViewById(R.id.quxiao);

        quxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        TextView queding = (TextView) rootView.findViewById(R.id.queding);
        queding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,itemString,Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        dialog.setContentView(rootView);
        dialog.show();
```
### 感谢
*[https://github.com/wangjiegulu/WheelView](https://github.com/wangjiegulu/WheelView)<br>
原有基础上修改的
