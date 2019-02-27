<xsl:stylesheet version="1.0" xmlns="http://www.w3.org/1999/XSL/Transform"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="BOOKS">
        <xsl:copy>
            <xsl:for-each select="BOOK">
                <xsl:sort select="NAME"/>
                <xsl:sort select="COST"/>
                <xsl:copy-of select="."/>
            </xsl:for-each>
        </xsl:copy>
    </xsl:template>
</xsl:stylesheet>