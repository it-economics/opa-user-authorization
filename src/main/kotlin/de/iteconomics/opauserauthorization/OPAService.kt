package de.iteconomics.opauserauthorization

import org.springframework.security.core.Authentication
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpServerErrorException.NotImplemented

@Service
class OPAService {
    fun checkAccess(authentication: Authentication, method: String, pathElements: List<String>): Boolean {
        TODO("Not Implemented")
    }
}
