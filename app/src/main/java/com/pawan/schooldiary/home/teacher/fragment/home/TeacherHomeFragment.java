package com.pawan.schooldiary.home.teacher.fragment.home;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import com.pawan.schooldiary.R;
import com.pawan.schooldiary.home.fragment.contacts.ContactsFragment_;
import com.pawan.schooldiary.home.fragment.chat.ChatFragment_;
import com.pawan.schooldiary.home.model.ViewPagerHelper;
import com.pawan.schooldiary.home.teacher.activity.TeacherHomeActivity;
import com.pawan.schooldiary.home.teacher.adapter.TeacherViewPagerAdapter;
import com.pawan.schooldiary.home.teacher.fragment.group.TeacherGroupFragment_;


import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_teacher_home)
public class TeacherHomeFragment extends Fragment implements ViewPagerHelper{

    @ViewById(R.id.tab_layout)
    TabLayout tabLayout;

    @ViewById(R.id.view_pager)
    ViewPager viewPager;

    private PagerAdapter pagerAdapter;

    @AfterViews
    void init() {
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        TeacherHomeActivity teacherHomeActivity = (TeacherHomeActivity) getActivity();
        teacherHomeActivity.initViewPagerHelper(this);
    }

    public void setupViewPager(ViewPager viewPager) {
        TeacherViewPagerAdapter adapter = new TeacherViewPagerAdapter(getActivity().getSupportFragmentManager());
        adapter.addFragment(new TeacherGroupFragment_(), "Group");
        adapter.addFragment(new ContactsFragment_(), "Recent");
        adapter.addFragment(new ContactsFragment_(), "Contacts");
        viewPager.setAdapter(adapter);
    }


    @Override
    public ViewPager getViewPager() {
        return this.viewPager;
    }

}
