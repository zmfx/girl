package com.zmfx.girl;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/show")
public class ParamController {

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String test(){
        return "success";
    }
    //id在路径末端
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String showId(@PathVariable("id")Integer myId){
        return "id:"+myId;//http://127.0.0.1:8081/show/user/1223
    }
    //id在路径其它位置
    @RequestMapping(value = "/{id}/user",method = RequestMethod.GET)
    public String showIdBeforePath(@PathVariable("id")Integer myId){
        return "id:"+myId;//http://127.0.0.1:8081/show/1223/user
    }
    //使用？拼接参数
    //@RequestMapping(value = "/append",method = RequestMethod.GET)
    @GetMapping("/append")
    public String showIdByAppend(@RequestParam(value = "id",required = false,defaultValue = "0")Integer myId){
        return "id:"+myId;
    }

}
