package com.cs393Project.cs393Project.Repositories;



import com.cs393Project.cs393Project.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}

