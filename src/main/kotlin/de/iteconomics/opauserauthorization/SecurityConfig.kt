package de.iteconomics.opauserauthorization

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.access.AccessDecisionManager
import org.springframework.security.access.AccessDecisionVoter
import org.springframework.security.access.vote.AuthenticatedVoter
import org.springframework.security.access.vote.RoleVoter
import org.springframework.security.access.vote.UnanimousBased
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter


@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
class SecurityConfig {

    @Configuration
    class OPAConfig(
            private val opaVoter: OPAVoter
    ) : WebSecurityConfigurerAdapter() {
        override fun configure(http: HttpSecurity?) {
            http!!.cors().disable()
                    .authorizeRequests()
                    .anyRequest().authenticated()
                    .accessDecisionManager(accessDecisionManager())
                    .and().formLogin().disable()
                    .httpBasic()
        }

        @Bean
        fun accessDecisionManager(): AccessDecisionManager? {
            val decisionVoters = listOf<AccessDecisionVoter<*>>(
                    RoleVoter(), AuthenticatedVoter(), opaVoter
            )
            return UnanimousBased(decisionVoters)
        }
    }
}