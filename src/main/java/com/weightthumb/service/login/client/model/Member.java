package com.weightthumb.service.login.client.model;

import com.weightthumb.common.oauth.OAuthProvider;
import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "members")
@Data
@NoArgsConstructor
@Builder
public class Member implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String nickname;
    private String sex;
    private String age;
    private Integer height;
    private String activityLevel;
    private Double weight;
    private Double goalWeight;
    private Integer goalCalorie;
    private String diet;
    private String profile;
    private String birthday;
    @Column(name = "o_auth_provider")
    private OAuthProvider oauthProvider;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Builder
    public Member(Long id, String email, String nickname, String sex, String age, Integer height,
                  String activityLevel, Double weight, Double goalWeight, Integer goalCalorie, String diet
                , String profile, String birthday, OAuthProvider oauthProvider, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.sex = sex;
        this.age = age;
        this.height = height;
        this.activityLevel = activityLevel;
        this.weight = weight;
        this.goalWeight = goalWeight;
        this.goalCalorie = goalCalorie;
        this.diet = diet;
        this.profile = profile;
        this.birthday = birthday;
        this.oauthProvider = oauthProvider;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
