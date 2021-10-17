package com.example.demo.slice;
import com.example.demo.fraction.HomeFraction;
import com.example.demo.ResourceTable;
//import com.example.demo.fraction.MyFraction;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.ability.fraction.Fraction;
import ohos.aafwk.ability.fraction.FractionAbility;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.global.resource.Resource;
public class MainAbilitySlice extends AbilitySlice  implements Component.ClickedListener {
    private Button homebtn,mybtn;
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        homebtn= (Button) findComponentById(ResourceTable.Id_main_home_btn);
        mybtn= (Button) findComponentById(ResourceTable.Id_main_my_btn);
        homebtn.setClickedListener(this);
        mybtn.setClickedListener(this);
        addHomeFraction();
    }
    private void  addHomeFraction(){
        ((FractionAbility)getAbility()).getFractionManager()
                .startFractionScheduler()
                .add(ResourceTable.Id_mainstack, new HomeFraction())
                .submit();
    }


    private void  replaceHomeFraction(){
        ((FractionAbility)getAbility()).getFractionManager()
                .startFractionScheduler()
                .replace(ResourceTable.Id_mainstack, new HomeFraction())
                .submit();
    }
    private void  replaceMyFraction(){
        ((FractionAbility)getAbility()).getFractionManager()
                .startFractionScheduler()
                .replace(ResourceTable.Id_mainstack, new HomeFraction())
                .submit();
    }
    @Override
    public void onActive() {
        super.onActive();
    }
    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }


    @Override
    public void onClick(Component component) {
        switch (component.getId()){
            case ResourceTable.Id_main_home_btn:
                replaceHomeFraction();
                break;
            case ResourceTable.Id_main_my_btn:
                replaceMyFraction();
                break;
            default:
                break;

        }
    }
}
