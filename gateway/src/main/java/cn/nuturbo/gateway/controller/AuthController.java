package cn.nuturbo.gateway.controller;

import cn.nuturbo.common.vo.Result;
import cn.nuturbo.gateway.entity.vo.request.AskCodeRequest;
import cn.nuturbo.gateway.security.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by penghs at 2024/2/18 14:58
 */
@RestController
@RequestMapping("api/auth")
public class AuthController {

    private final AccountService accountService;

    public AuthController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/ask-code")
    public Result<Void> askVerifyCode(AskCodeRequest askCodeRequest,
                                      HttpServletRequest request) {
        accountService.registerEmailVerifyCode(askCodeRequest, request.getRemoteAddr());
        return Result.success();
    }

    /*  *//**
     * 进行用户注册操作，需要先请求邮件验证码
     * @param vo 注册信息
     * @return 是否注册成功
     *//*
    @PostMapping("/register")
    @Operation(summary = "用户注册操作")
    public RestBean<Void> register(@RequestBody @Valid EmailRegisterVO vo) {
        return this.messageHandle(() ->
                accountService.registerEmailAccount(vo));
    }

    *//**
     * 执行密码重置确认，检查验证码是否正确
     * @param vo 密码重置信息
     * @return 是否操作成功
     *//*
    @PostMapping("/reset-confirm")
    @Operation(summary = "密码重置确认")
    public RestBean<Void> resetConfirm(@RequestBody @Valid ConfirmResetVO vo) {
        return this.messageHandle(() -> accountService.resetConfirm(vo));
    }

    *//**
     * 执行密码重置操作
     * @param vo 密码重置信息
     * @return 是否操作成功
     *//*
    @PostMapping("/reset-password")
    @Operation(summary = "密码重置操作")
    public RestBean<Void> resetPassword(@RequestBody @Valid EmailResetVO vo) {
        return this.messageHandle(() ->
                accountService.resetEmailAccountPassword(vo));
    }

    *//**
     * 针对于返回值为String作为错误信息的方法进行统一处理
     * @param action 具体操作
     * @return 响应结果
     * @param <T> 响应结果类型
     *//*
    private <T> RestBean<T> messageHandle(Supplier<String> action) {
        String message = action.get();
        if (message == null)
            return RestBean.success();
        else
            return RestBean.failure(400, message);
    }*/

}