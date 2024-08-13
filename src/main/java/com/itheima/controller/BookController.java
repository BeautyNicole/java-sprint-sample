package com.itheima.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.itheima.dao.BookDaoInterface;
import com.itheima.domain.Book;
import com.itheima.service.BookServiceInterface;
import com.itheima.service.impl.BookService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/book")
@CrossOrigin(origins = "*")
//@SessionAttributes("session-id")
//@WebServlet("/book")
public class BookController extends HttpServlet {

    // 获取request/response
    // 方式一: 通过注解
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

    {
        response.addHeader("Access-Control-Allow-Origin", "*");
    }

    // 获取request/response
    // 方式二：
    ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
    HttpServletRequest req = servletRequestAttributes.getRequest();
    HttpServletResponse res = servletRequestAttributes.getResponse();


    @Autowired
    private BookServiceInterface bookService;

    @GetMapping("{id}")
    public Book getBookById(@PathVariable int id) throws IOException, ServletException {
        System.out.println("Request----------------------------------------");
        // 设置编码方式
        request.setCharacterEncoding("utf-8");
        // 获取参数集合
        Map<String, String[]> parameterMap = request.getParameterMap();
        // 设置request 属性， 多个请求之间可以共享
        request.setAttribute("user-agent", "my company");

        System.out.println("Request Session----------------------------------------");
        // 获取session 对象
        HttpSession session = request.getSession();
        // 设置session id
        session.setAttribute("session-id", UUID.randomUUID());
        // 获取session id
        System.out.println("session-id: " + request.getSession().getId());


        System.out.println("Request Forward----------------------------------------");
        // 转发 - 发生在服务器端， 浏览器地址栏不发生变化， 相当于一个请求， 多个转发请求之间共享数据
        // request.getRequestDispatcher("/all").forward(request, response);

        System.out.println("Response----------------------------------------");
        // 设置相应状态码
        response.setStatus(HttpServletResponse.SC_OK);
        // 设置响应头
        response.setHeader("Content-Type", "text/html");
        // 设置响应类型
        response.setContentType("text/html;charset=UTF-8");
        // 设置相应编码方式
        response.setCharacterEncoding("utf-8");

        System.out.println("Redirect----------------------------------------");
        // 重定向 - 发生在浏览器端， 浏览器地址栏发生变化， 相当于两个请求， 数据无法共享
        // response.sendRedirect("new url");


        System.out.println("Cookie----------------------------------------");
        Cookie cookie = new Cookie("username", "Carrie");
        response.addCookie(cookie);

        // 如果应用程序需要返回JSON格式数据， 需要引入JSON库将Java对象转换成JSON格式数据， 将JSON字符串写入响应体
        System.out.println("JSON----------------------------------------");

        System.out.println("Handle Cache----------------------------------------");
        // 设置响应头部，指定缓存有效期为一小时
        response.setHeader("Cache-Control", "max-age=3600");



        return bookService.getBookById(id);
    }

    @DeleteMapping("{id}")
    public boolean deleteBookById(@PathVariable int id) {

        return bookService.deleteBookById(id);
    }

    // 方式二：通过参数获取request/response
    @GetMapping("/all")
    public List<Book> getAllBooks(HttpServletRequest request) {
//        model.addAttribute("session-id", UUID.randomUUID());
        // 获取session 对象
        HttpSession session = request.getSession();
        // 设置session id
        session.setAttribute("session-id", UUID.randomUUID());

        List<Book> result = bookService.getAllBooks();

        return result;
    }

    @PostMapping("/add")
    public int addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @PutMapping("/update")
    public void updateBook(@RequestBody Book book) {
        bookService.updateBook(book);
    }

}
