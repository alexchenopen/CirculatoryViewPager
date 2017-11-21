
# CirculatoryViewPager
该控件支持水平、竖直方向滑动，并可循环展示。


## 截图

横向滑动</br>
<img src="screens/circle_1.gif" />

竖向滑动</br>
<img src="screens/circle_2.gif" />


## 使用方法
Gradle配置

### 1. 在project的build.gradle添加如下代码

```
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```
### 2. 在Module的build.gradle添加依赖

```
compile "com.github.alexchenopen:CirculatoryViewPager:0.0.1"
```

### 3. 在xml中使用该控件

```
<com.alex.widget.CirculatoryViewPager
            android:id="@+id/viewpager"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_gravity="center"
            app:circulationCount="600"
            app:isCirculatory="true"
            app:orientation="vertical"/>
            
```
### 4、自定义的FragmentPagerAdapter需要继承CirculatoryFragmentPagerAdapter

```
class FragmentAdapter extends CirculatoryFragmentPagerAdapter {

        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }
 ```
 ### 5、viewPager绑定自定义的PagerAdapter即可使用
 ```
 mViewPager.setAdapter(mAdapter)
 ```
