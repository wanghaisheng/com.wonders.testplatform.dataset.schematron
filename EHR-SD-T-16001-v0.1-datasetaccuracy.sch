<?xml version="1.0" encoding="UTF-8"?>
<schema xmlns:iso="http://purl.oclc.org/dsdl/schematron" xmlns:xi="http://www.w3.org/2003/XInclude" xmlns:queryBinding="xslt2">
  <ns prefix="urn:hl7-org:v3" />
  <ns prefix="http://www.w3.org/2001/XMLSchema-instance" />
  <!--$dataelementid 数据集内数据元标识符-->
  <pattern abstract="true" id="check-dataelement-existed">
    <rule context="$context">
      <assert test="count($path) &amp;gt;= 1" role="$dataelementid">错误:&amp;lt;value-of select="'$dataelementid'"/&amp;gt;  &amp;lt;value-of select="'$dataelementname'"/&amp;gt;  数据元不存在</assert>
      <assert test="count($path) &amp;gt;= 1" role="$dataelementid">正确:&amp;lt;value-of select="'$dataelementid'"/&amp;gt;  &amp;lt;value-of select="'$dataelementname'"/&amp;gt;  数据元已存在</assert>
    </rule>
  </pattern>
  <pattern is-a="check-value-match" id="HDSD00.01.002">
    <param name="dataelementid" value="DE02.01.039.00" />
    <param name="dataelementname" value="本人姓名" />
    <param name="datatype" value="S1" />
    <param name="format" value="A..50" />
    <param name="xpath" value="/" />
    <param name="regex" value="(^\p{L}{0,25}$)|(^[\p{Ll}-\p{Lu}]{0,50}$)" />
  </pattern>
  <pattern is-a="check-value-match" id="HDSD00.01.003">
    <param name="dataelementid" value="DE02.01.040.00" />
    <param name="dataelementname" value="性别代码" />
    <param name="datatype" value="S3" />
    <param name="format" value="N1" />
    <param name="xpath" value="/" />
    <param name="regex" value="([0-9]{1})" />
  </pattern>
  <pattern is-a="check-value-match" id="HDSD00.01.004">
    <param name="dataelementid" value="DE02.01.005.01" />
    <param name="dataelementname" value="出生日期" />
    <param name="datatype" value="D" />
    <param name="format" value="D8" />
    <param name="xpath" value="/" />
    <param name="regex" value="(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})(((0[13578]|1[02])(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)(0[1-9]|[12][0-9]|30))|(02(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))0229)" />
  </pattern>
  <pattern is-a="check-value-match" id="HDSD00.01.005">
    <param name="dataelementid" value="DE02.01.031.00" />
    <param name="dataelementname" value="身份证件类别代码" />
    <param name="datatype" value="S3" />
    <param name="format" value="N2" />
    <param name="xpath" value="/" />
    <param name="regex" value="([0-9]{2})" />
  </pattern>
  <pattern is-a="check-value-match" id="HDSD00.01.006">
    <param name="dataelementid" value="DE02.01.030.00" />
    <param name="dataelementname" value="身份证件号码" />
    <param name="datatype" value="S1" />
    <param name="format" value="AN..18" />
    <param name="xpath" value="/" />
    <param name="regex" value="(^\p{L}{0,9}$)|(^[\p{Ll}-\p{Lu}]{0,18}$)|([0-9]{0,18})" />
  </pattern>
  <pattern is-a="check-value-match" id="HDSD00.01.007">
    <param name="dataelementid" value="DE08.10.007.00" />
    <param name="dataelementname" value="工作单位名称" />
    <param name="datatype" value="S1" />
    <param name="format" value="A..70" />
    <param name="xpath" value="/" />
    <param name="regex" value="(^\p{L}{0,35}$)|(^[\p{Ll}-\p{Lu}]{0,70}$)" />
  </pattern>
  <pattern is-a="check-value-match" id="HDSD00.01.008">
    <param name="dataelementid" value="DE02.01.010.00" />
    <param name="dataelementname" value="本人电话号码" />
    <param name="datatype" value="S1" />
    <param name="format" value="N..20" />
    <param name="xpath" value="/" />
    <param name="regex" value="|([0-9]{0,20})" />
  </pattern>
  <pattern is-a="check-value-match" id="HDSD00.01.009">
    <param name="dataelementid" value="DE02.01.041.00" />
    <param name="dataelementname" value="联系人姓名" />
    <param name="datatype" value="S1" />
    <param name="format" value="A..50" />
    <param name="xpath" value="/" />
    <param name="regex" value="(^\p{L}{0,25}$)|(^[\p{Ll}-\p{Lu}]{0,50}$)" />
  </pattern>
  <pattern is-a="check-value-match" id="HDSD00.01.010">
    <param name="dataelementid" value="DE02.01.010.00" />
    <param name="dataelementname" value="联系人电话号码" />
    <param name="datatype" value="S1 " />
    <param name="format" value="A..20" />
    <param name="xpath" value="/" />
    <param name="regex" value="(^\p{L}{0,10}$)|(^[\p{Ll}-\p{Lu}]{0,20}$)" />
  </pattern>
  <pattern is-a="check-value-match" id="HDSD00.01.011">
    <param name="dataelementid" value="DE02.01.003.00" />
    <param name="dataelementname" value="常住地址户籍标志" />
    <param name="datatype" value="L" />
    <param name="format" value="TF" />
    <param name="xpath" value="/" />
    <param name="regex" value="(0|1|T|F|False|True)" />
  </pattern>
  <pattern is-a="check-value-match" id="HDSD00.01.012">
    <param name="dataelementid" value="DE02.01.025.00" />
    <param name="dataelementname" value="民族" />
    <param name="datatype" value="S3" />
    <param name="format" value="N2" />
    <param name="xpath" value="/" />
    <param name="regex" value="([0-9]{2})" />
  </pattern>
  <pattern is-a="check-value-match" id="HDSD00.01.013">
    <param name="dataelementid" value="DE04.50.001.00" />
    <param name="dataelementname" value="ABO血型代码" />
    <param name="datatype" value="S3" />
    <param name="format" value="N1" />
    <param name="xpath" value="/" />
    <param name="regex" value="([0-9]{1})" />
  </pattern>
  <pattern is-a="check-value-match" id="HDSD00.01.014">
    <param name="dataelementid" value="DE04.50.010.00" />
    <param name="dataelementname" value="Rh血型代码" />
    <param name="datatype" value="S2" />
    <param name="format" value="N1" />
    <param name="xpath" value="/" />
    <param name="regex" value="([0-9]{1})" />
  </pattern>
  <pattern is-a="check-value-match" id="HDSD00.01.015">
    <param name="dataelementid" value="DE02.01.041.00" />
    <param name="dataelementname" value="学历代码" />
    <param name="datatype" value="S3" />
    <param name="format" value="N2" />
    <param name="xpath" value="/" />
    <param name="regex" value="([0-9]{2})" />
  </pattern>
  <pattern is-a="check-value-match" id="HDSD00.01.016">
    <param name="dataelementid" value="DE02.01.052.00" />
    <param name="dataelementname" value="职业类别代码" />
    <param name="datatype" value="S3" />
    <param name="format" value="AN..3" />
    <param name="xpath" value="/" />
    <param name="regex" value="(^\p{L}{0,1}$)|(^[\p{Ll}-\p{Lu}]{0,3}$)|([0-9]{0,3})" />
  </pattern>
  <pattern is-a="check-value-match" id="HDSD00.01.017">
    <param name="dataelementid" value="DE02.01.018.00" />
    <param name="dataelementname" value="婚姻状况类别代码" />
    <param name="datatype" value="S3" />
    <param name="format" value="N2" />
    <param name="xpath" value="/" />
    <param name="regex" value="([0-9]{2})" />
  </pattern>
  <pattern is-a="check-value-match" id="HDSD00.01.018">
    <param name="dataelementid" value="DE07.00.007.00" />
    <param name="dataelementname" value="医疗费用支付方式代码" />
    <param name="datatype" value="S3" />
    <param name="format" value="N1" />
    <param name="xpath" value="/" />
    <param name="regex" value="([0-9]{1})" />
  </pattern>
  <pattern is-a="check-value-match" id="HDSD00.01.019">
    <param name="dataelementid" value="DE05.01.022.00" />
    <param name="dataelementname" value="药物过敏史标志" />
    <param name="datatype" value="L" />
    <param name="format" value="TF" />
    <param name="xpath" value="/" />
    <param name="regex" value="(0|1|T|F|False|True)" />
  </pattern>
  <pattern is-a="check-value-match" id="HDSD00.01.020">
    <param name="dataelementid" value="DE05.01.022.00" />
    <param name="dataelementname" value="药物过敏源" />
    <param name="datatype" value="S3" />
    <param name="format" value="N..3" />
    <param name="xpath" value="/" />
    <param name="regex" value="|([0-9]{0,3})" />
  </pattern>
  <pattern is-a="check-value-match" id="HDSD00.01.021">
    <param name="dataelementid" value="DE03.00.021.00" />
    <param name="dataelementname" value="环境危险因素暴露类别代码" />
    <param name="datatype" value="S3" />
    <param name="format" value="N1" />
    <param name="xpath" value="/" />
    <param name="regex" value="([0-9]{1})" />
  </pattern>
  <pattern is-a="check-value-match" id="HDSD00.01.022">
    <param name="dataelementid" value="DE02.10.021.00" />
    <param name="dataelementname" value="既往患病种类代码" />
    <param name="datatype" value="S3" />
    <param name="format" value="N2" />
    <param name="xpath" value="/" />
    <param name="regex" value="([0-9]{2})" />
  </pattern>
  <pattern is-a="check-value-match" id="HDSD00.01.023">
    <param name="dataelementid" value="DE05.01.035.00" />
    <param name="dataelementname" value="既往患病确诊日期" />
    <param name="datatype" value="D" />
    <param name="format" value="D8" />
    <param name="xpath" value="/" />
    <param name="regex" value="(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})(((0[13578]|1[02])(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)(0[1-9]|[12][0-9]|30))|(02(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))0229)" />
  </pattern>
  <pattern is-a="check-value-match" id="HDSD00.01.024">
    <param name="dataelementid" value="DE02.10.062.00" />
    <param name="dataelementname" value="手术史标志" />
    <param name="datatype" value="L" />
    <param name="format" value="TF" />
    <param name="xpath" value="/" />
    <param name="regex" value="(0|1|T|F|False|True)" />
  </pattern>
  <pattern is-a="check-value-match" id="HDSD00.01.025">
    <param name="dataelementid" value="DE02.10.061.00" />
    <param name="dataelementname" value="手术史" />
    <param name="datatype" value="S1" />
    <param name="format" value="AN..100" />
    <param name="xpath" value="/" />
    <param name="regex" value="(^\p{L}{0,50}$)|(^[\p{Ll}-\p{Lu}]{0,100}$)|([0-9]{0,100})" />
  </pattern>
  <pattern is-a="check-value-match" id="HDSD00.01.026">
    <param name="dataelementid" value="DE06.00.095.00" />
    <param name="dataelementname" value="手术操作日期时间" />
    <param name="datatype" value="DT" />
    <param name="format" value="DT15" />
    <param name="xpath" value="/" />
    <param name="regex" value="((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})(((0[13578]|1[02])(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)(0[1-9]|[12][0-9]|30))|(02(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))0229))T((([1-9])|([0-1][0-9])|([1-2][0-3]))(([0-5][0-9]))(([0-5][0-9])))" />
  </pattern>
  <pattern is-a="check-value-match" id="HDSD00.01.027">
    <param name="dataelementid" value="DE02.10.069.00" />
    <param name="dataelementname" value="外伤史标志" />
    <param name="datatype" value="L" />
    <param name="format" value="TF" />
    <param name="xpath" value="/" />
    <param name="regex" value="(0|1|T|F|False|True)" />
  </pattern>
  <pattern is-a="check-value-match" id="HDSD00.01.028">
    <param name="dataelementid" value="DE02.10.068.00" />
    <param name="dataelementname" value="外伤名称" />
    <param name="datatype" value="S1" />
    <param name="format" value="AN..100" />
    <param name="xpath" value="/" />
    <param name="regex" value="(^\p{L}{0,50}$)|(^[\p{Ll}-\p{Lu}]{0,100}$)|([0-9]{0,100})" />
  </pattern>
  <pattern is-a="check-value-match" id="HDSD00.01.029">
    <param name="dataelementid" value="DE02.10.067.00" />
    <param name="dataelementname" value="外伤发生时间" />
    <param name="datatype" value="DT" />
    <param name="format" value="DT15" />
    <param name="xpath" value="/" />
    <param name="regex" value="((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})(((0[13578]|1[02])(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)(0[1-9]|[12][0-9]|30))|(02(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))0229))T((([1-9])|([0-1][0-9])|([1-2][0-3]))(([0-5][0-9]))(([0-5][0-9])))" />
  </pattern>
  <pattern is-a="check-value-match" id="HDSD00.01.030">
    <param name="dataelementid" value="DE06.00.106.00" />
    <param name="dataelementname" value="输血史标志" />
    <param name="datatype" value="L" />
    <param name="format" value="TF" />
    <param name="xpath" value="/" />
    <param name="regex" value="(0|1|T|F|False|True)" />
  </pattern>
  <pattern is-a="check-value-match" id="HDSD00.01.031">
    <param name="dataelementid" value="DE06.00.107.00" />
    <param name="dataelementname" value="输血原因" />
    <param name="datatype" value="S1" />
    <param name="format" value="AN..100" />
    <param name="xpath" value="/" />
    <param name="regex" value="(^\p{L}{0,50}$)|(^[\p{Ll}-\p{Lu}]{0,100}$)|([0-9]{0,100})" />
  </pattern>
  <pattern is-a="check-value-match" id="HDSD00.01.032">
    <param name="dataelementid" value="DE06.00.105.00" />
    <param name="dataelementname" value="输血日期时间" />
    <param name="datatype" value="DT" />
    <param name="format" value="DT15" />
    <param name="xpath" value="/" />
    <param name="regex" value="((([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})(((0[13578]|1[02])(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)(0[1-9]|[12][0-9]|30))|(02(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))0229))T((([1-9])|([0-1][0-9])|([1-2][0-3]))(([0-5][0-9]))(([0-5][0-9])))" />
  </pattern>
  <pattern is-a="check-value-match" id="HDSD00.01.033">
    <param name="dataelementid" value="DE02.10.095.00" />
    <param name="dataelementname" value="家族性疾病名称代码" />
    <param name="datatype" value="S3" />
    <param name="format" value="N2" />
    <param name="xpath" value="/" />
    <param name="regex" value="([0-9]{2})" />
  </pattern>
  <pattern is-a="check-value-match" id="HDSD00.01.034">
    <param name="dataelementid" value="DE02.10.024.00" />
    <param name="dataelementname" value="患者与本人关系代码" />
    <param name="datatype" value="S3" />
    <param name="format" value="N2" />
    <param name="xpath" value="/" />
    <param name="regex" value="([0-9]{2})" />
  </pattern>
  <pattern is-a="check-value-match" id="HDSD00.01.035">
    <param name="dataelementid" value="DE02.10.026.00" />
    <param name="dataelementname" value="遗传性疾病史" />
    <param name="datatype" value="S1" />
    <param name="format" value="AN..100" />
    <param name="xpath" value="/" />
    <param name="regex" value="(^\p{L}{0,50}$)|(^[\p{Ll}-\p{Lu}]{0,100}$)|([0-9]{0,100})" />
  </pattern>
  <pattern is-a="check-value-match" id="HDSD00.01.036">
    <param name="dataelementid" value="DE05.10.006.00" />
    <param name="dataelementname" value="残疾情况代码" />
    <param name="datatype" value="S3" />
    <param name="format" value="N2" />
    <param name="xpath" value="/" />
    <param name="regex" value="([0-9]{2})" />
  </pattern>
  <pattern is-a="check-value-match" id="HDSD00.01.037">
    <param name="dataelementid" value="DE03.00.099.00" />
    <param name="dataelementname" value="家庭厨房排风设施标识" />
    <param name="datatype" value="L" />
    <param name="format" value="TF" />
    <param name="xpath" value="/" />
    <param name="regex" value="(0|1|T|F|False|True)" />
  </pattern>
  <pattern is-a="check-value-match" id="HDSD00.01.038">
    <param name="dataelementid" value="DE03.00.006.00" />
    <param name="dataelementname" value="家庭厨房排风设施类别代码" />
    <param name="datatype" value="S3" />
    <param name="format" value="N1" />
    <param name="xpath" value="/" />
    <param name="regex" value="([0-9]{1})" />
  </pattern>
  <pattern is-a="check-value-match" id="HDSD00.01.039">
    <param name="dataelementid" value="DE03.00.050.00" />
    <param name="dataelementname" value="家庭燃料类型类别代码" />
    <param name="datatype" value="S3" />
    <param name="format" value="N1" />
    <param name="xpath" value="/" />
    <param name="regex" value="([0-9]{1})" />
  </pattern>
  <pattern is-a="check-value-match" id="HDSD00.01.040">
    <param name="dataelementid" value="DE03.00.082.00" />
    <param name="dataelementname" value="家庭饮水类别代码" />
    <param name="datatype" value="S3" />
    <param name="format" value="N1" />
    <param name="xpath" value="/" />
    <param name="regex" value="([0-9]{1})" />
  </pattern>
  <pattern is-a="check-value-match" id="HDSD00.01.041">
    <param name="dataelementid" value="DE03.00.005.00" />
    <param name="dataelementname" value="家庭厕所类别代码" />
    <param name="datatype" value="S3" />
    <param name="format" value="N1" />
    <param name="xpath" value="/" />
    <param name="regex" value="([0-9]{1})" />
  </pattern>
  <pattern is-a="check-value-match" id="HDSD00.01.042">
    <param name="dataelementid" value="DE03.00.049.00" />
    <param name="dataelementname" value="家庭禽畜栏类别" />
    <param name="datatype" value="S2" />
    <param name="format" value="N1" />
    <param name="xpath" value="/" />
    <param name="regex" value="([0-9]{1})" />
  </pattern>
</schema>

