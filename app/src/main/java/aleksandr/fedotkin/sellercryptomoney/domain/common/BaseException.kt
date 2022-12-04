package aleksandr.fedotkin.sellercryptomoney.domain.common

open class BaseException(val extraErrorCode: Int, override val message: String? = null) :
    Exception(message)

