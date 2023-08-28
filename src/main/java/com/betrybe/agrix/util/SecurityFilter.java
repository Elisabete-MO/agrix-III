//package com.betrybe.agrix.util;
//
//import com.betrybe.agrix.services.PersonService;
//import com.betrybe.agrix.services.TokenService;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
///**
// * Filter to validate the token and authenticate the user.
// */
//@Component
//public class SecurityFilter extends OncePerRequestFilter {
//
//  private final TokenService tokenService;
//
//  private final PersonService personService;
//
//  @Autowired
//  public SecurityFilter(TokenService tokenService, PersonService personService) {
//    this.tokenService = tokenService;
//    this.personService = personService;
//  }
//
//  @Override
//  protected void doFilterInternal(HttpServletRequest request,
//                                  HttpServletResponse response,
//                                  FilterChain filterChain)
//      throws ServletException, IOException {
//    String token = recoveryToken(request);
//
//    if (token != null) {
//      String subject = tokenService.validateToken(token);
//      UserDetails userDetails = personService.loadUserByUsername(subject);
//
//      UsernamePasswordAuthenticationToken authentication =
//          new UsernamePasswordAuthenticationToken(
//          userDetails, null, userDetails.getAuthorities());
//      SecurityContextHolder.getContext().setAuthentication(authentication);
//    }
//
//    filterChain.doFilter(request, response);
//  }
//
//  private String recoveryToken(HttpServletRequest request) {
//    String authHeader = request.getHeader("Authorization");
//    if (authHeader == null) {
//      return null;
//    }
//    return authHeader.replace("Bearer ", "");
//  }
//}
