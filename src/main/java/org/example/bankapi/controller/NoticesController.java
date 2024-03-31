package org.example.bankapi.controller;

import org.example.bankapi.entity.Notice;
import org.example.bankapi.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/notices/")
public class NoticesController {

    private final NoticeService noticeService;

    @Autowired
    public NoticesController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @GetMapping("/myNotice")
    public ResponseEntity<List<Notice>> getActiveNotices() {
        return ResponseEntity.ok()
                .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                .body(noticeService.getActiveNotices());
    }

    @PostMapping("/createNotice")
    public ResponseEntity<Notice> createNotice(@RequestBody Notice notice) {
        notice.setNoticeId(0);
        noticeService.CreateNotice(notice);
        return ResponseEntity.ok(notice);
    }
}
