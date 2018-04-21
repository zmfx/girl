package com.zmfx.girl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GirlController {
    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;

    /**
     * 查询所有女生
     * @return
     */
    @GetMapping(value="/girls")
    public List<Girl> girlList(){
        return girlRepository.findAll();//findAll是别人帮我们写好的方法
    }

    /**
     * 添加一个女生
     * @param cupSize
     * @param age
     * @return
     */
    @PostMapping(value = "/girls/add")
    public Girl girlAdd(@RequestParam("cupSize")String cupSize,
                          @RequestParam("age") Integer age){
        Girl girl=new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);

        return girlRepository.save(girl);//会返回一个添加的对象
    }

    @GetMapping(value = "/girls/{id}")
    public Girl getOneGirl(@PathVariable("id")Integer id){
        return girlRepository.findOne(id);

    }
    //更新
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id")Integer id,
                           @RequestParam("cupSize")String cupSize,
                           @RequestParam("age") Integer age){
        Girl girl =new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }
    //删除
    @DeleteMapping(value="/girls/{id}")
    public void girlDelete(@PathVariable("id")Integer id){
        girlRepository.delete(id);
    }
    //通过年龄查询女生列表
    @GetMapping("/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age")Integer age){
        return girlRepository.findByAge(age);
    }
    //测试事务
    @PostMapping(value = "/girls/two")
    public void girlTwo(){
        girlService.insertTwo();
    }

}
