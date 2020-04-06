package com.csj.cn.provider.service;

import com.csj.cn.common.dto.Book;
import com.csj.cn.common.dto.BookExample;
import com.csj.cn.provider.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl {
    @Autowired
    private BookMapper bookMapper;

    /**
     * 添加图书
     * @param book
     * @return
     */
    public boolean insert(Book book) {
        try {
            bookMapper.insertSelective(book);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /*public PageUtils selectBook(PageUtils pageUtils) {
        BookExample bookExample = new BookExample();
        bookExample.setOrderByClause("id desc");
        bookExample.setLimit(pageUtils.getPageNo());
        bookExample.setOffset(pageUtils.getPageSize());
        pageUtils.setTotalCount(bookMapper.countByExample(bookExample));
        pageUtils.setCurrentList(bookMapper.selectByExample(bookExample));
        return pageUtils;
    }*/

    public boolean update() {
        Book book = new Book();
        book.setName("像狗一样奔跑1");
        BookExample bookExample = new BookExample();
        bookExample.createCriteria().andNameEqualTo("像狗一样奔跑").andAuthorEqualTo("里则林").andPageEqualTo(2000);
        return bookMapper.updateByExampleSelective(book, bookExample) > 0;
    }

    public boolean del() {
        BookExample bookExample = new BookExample();
        bookExample.createCriteria().andNameEqualTo("像狗一样奔跑1");
        return bookMapper.deleteByExample(bookExample) > 0;
    }

}
