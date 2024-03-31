package org.example.bankapi.service;

import org.example.bankapi.entity.Notice;
import org.example.bankapi.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoticeServiceImpl implements NoticeService{

    private final NoticeRepository noticeRepository;

    @Autowired
    public NoticeServiceImpl(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    @Override
    public void CreateNotice(Notice notice) {
        noticeRepository.save(notice);
    }

    @Override
    public Notice getNoticeById(int noticeId) {
        Optional<Notice> notice = noticeRepository.findById(noticeId);

        return notice.orElse(null);
    }

    @Override
    public void deleteNotice(int noticeId) {
        noticeRepository.deleteById(noticeId);
    }

    @Override
    public void updateNotice(Notice notice) {
        noticeRepository.save(notice);
    }

    @Override
    public List<Notice> getActiveNotices() {
        return noticeRepository.findAllActiveNotices();
    }
}
