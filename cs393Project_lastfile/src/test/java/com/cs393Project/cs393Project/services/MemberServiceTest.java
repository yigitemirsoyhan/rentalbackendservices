package com.cs393Project.cs393Project.services;

import com.cs393Project.cs393Project.models.Member;
import com.cs393Project.cs393Project.Repositories.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MemberServiceTest {

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberService memberService;

    private Member member;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        member = new Member("Jon Snow", "The Wall Street,Near Winterfell", "john@example.com", "555-1234", "DL12345");
    }

    @Test
    public void testGetAllMembers() {
        when(memberRepository.findAll()).thenReturn(List.of(member));

        List<Member> members = memberService.getAllMembers();
        assertEquals(1, members.size());
        assertEquals("Jon Snow", members.get(0).getName());
    }

    @Test
    public void testGetMemberById() {
        when(memberRepository.findById(1L)).thenReturn(Optional.of(member));

        Optional<Member> result = memberService.getMemberById(1L);
        assertTrue(result.isPresent());
        assertEquals("Jon Snow", result.get().getName());
    }

    @Test
    public void testAddMember() {
        when(memberRepository.save(member)).thenReturn(member);

        Member result = memberService.addMember(member);
        assertNotNull(result);
        assertEquals("Jon Snow", result.getName());
    }

    @Test
    public void testDeleteMember() {
        doNothing().when(memberRepository).deleteById(1L);

        memberService.deleteMember(1L);
        verify(memberRepository, times(1)).deleteById(1L);
    }
}
