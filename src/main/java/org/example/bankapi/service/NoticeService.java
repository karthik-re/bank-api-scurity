package org.example.bankapi.service;

import org.example.bankapi.entity.Notice;

import java.util.List;

public interface NoticeService {

    void CreateNotice(Notice notice);

    Notice getNoticeById(int noticeId);

    void deleteNotice(int noticeId);

    void updateNotice(Notice notice);

    List<Notice> getActiveNotices();
}
