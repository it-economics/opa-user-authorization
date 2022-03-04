package de.iteconomics.opauserauthorization

import org.springframework.security.access.AccessDecisionVoter
import org.springframework.security.access.ConfigAttribute
import org.springframework.security.core.Authentication
import org.springframework.security.web.FilterInvocation
import org.springframework.stereotype.Component

@Component
class OPAVoter(
        private val opaService: OPAService
) : AccessDecisionVoter<FilterInvocation> {
    override fun supports(attribute: ConfigAttribute?): Boolean = true

    override fun supports(clazz: Class<*>?): Boolean = clazz?.let {
        FilterInvocation::class.java.isAssignableFrom(clazz)
    } ?: false

    override fun vote(authentication: Authentication, filterInvocation: FilterInvocation, attributes: MutableCollection<ConfigAttribute>): Int =
            if (hasAccess(authentication, filterInvocation, attributes)) AccessDecisionVoter.ACCESS_GRANTED
            else AccessDecisionVoter.ACCESS_DENIED

    private fun hasAccess(authentication: Authentication, filterInvocation: FilterInvocation, attributes: MutableCollection<ConfigAttribute>) =
            opaService.checkAccess(
                    authentication,
                    filterInvocation.request.method,
                    filterInvocation.requestUrl.replace("^/|/$", "").split("/").filter { it != "" }
            )
}