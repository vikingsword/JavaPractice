package vikingar.usermanager.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vikingar.usermanager.entity.User;
import vikingar.usermanager.entity.query.UserQuery;
import vikingar.usermanager.service.UserService;

import java.util.List;
import java.util.Objects;

/**
 * @author vikingar
 * @time 2024/1/9 12:49
 * @description
 */
@Controller
@RequestMapping()
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 这样写就自动将 template 下面的 index.html 返回了
     */
    @GetMapping("/")
    public String index(Model module, UserQuery userQuery) {
        PageInfo<User> userPageInfo = userService.listUserByName(userQuery);
        module.addAttribute("page", userPageInfo);
        return "index";
    }

    @PostMapping("/")
    public String listUserByName(Model model, UserQuery userQuery) {
        PageInfo<User> userPageInfo = userService.listUserByName(userQuery);
        model.addAttribute("page", userPageInfo);
        return "index";
    }


    @GetMapping("delete/{id}")
    public String deleteUserById(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        Boolean flag = userService.deleteUserById(id);
        if (flag) {
            redirectAttributes.addFlashAttribute("message", "删除用户成功");
            return "redirect:/";
        } else {
            redirectAttributes.addFlashAttribute("message", "删除用户失败");
            return "redirect:/";
        }
    }


    @GetMapping("edit/{id}")
    public String toEdit(@PathVariable Integer id, Model model) {
        // 将用户的用户名和密码加进来
        model.addAttribute("user", userService.selectUserById(id));
        return "editUser";
    }


    @PostMapping("edit")
    public String edit(User user, RedirectAttributes attributes) {

        Integer id = user.getId();
        List<User> userList = userService.selectUserByName(user.getName());
        long count = userList.stream().filter(o -> !Objects.equals(o.getId(), user.getId())).count();
        if (id != null) {
            // 更新
            if (count == 0) {
                // 不存在该用户，可以修改
                Boolean flag = userService.updateUser(user);
                if (flag) {
                    attributes.addFlashAttribute("message", "修改成功");
                    return "redirect:/";
                } else {
                    attributes.addFlashAttribute("message", "修改失败");
                    return "redirect:/";
                }
            } else {
                // 有该用户，不能修改
                attributes.addFlashAttribute("无法修改", "该用户已经存在");
                return "redirect:/edit/" + user.getId();
            }
        } else {
            // 新增
            if (count == 0) {
                // 不存在该用户，可以新增
                Boolean flag = userService.adduser(user);
                if (flag) {
                    attributes.addFlashAttribute("message", "新增成功");
                    return "redirect:/";
                } else {
                    attributes.addFlashAttribute("message", "新增失败");
                    return "redirect:/";
                }
            } else {
                // 有该用户，不能新增
                attributes.addFlashAttribute("无法新增", "该用户已经存在");
                return "redirect:/edit/" + user.getId();
            }
        }
    }




    @GetMapping("update")
    public String toUpdate(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "editUser";
    }


}
